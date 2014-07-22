package com.adrielcafe.vacinarecife;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.adrielcafe.vacinarecife.adapter.VaccineCalendarAdapter;
import com.adrielcafe.vacinarecife.model.VaccineCalendar;
import com.google.gson.reflect.TypeToken;
import com.tjerkw.slideexpandable.library.SlideExpandableListAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class VaccineCalendarActivity extends ListActivity {
	private static final String[] ageOptions = new String[]{
		"Ao nascer",
		"2 meses",
		"3 meses",
		"4 meses",
		"5 meses",
		"6 meses",
		"9 meses",
		"12 meses",
		"15 meses",
		"4 anos",
		"10 anos",
		"10 a 19 anos",
		"20 a 59 anos",
		"60 anos e mais"
	};
	
	private List<VaccineCalendar> db;
	private Spinner ageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		overridePendingTransition(R.anim.open_activity, R.anim.close_activity);
		setContentView(R.layout.activity_vaccine);
		getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		ageView = (Spinner) findViewById(R.id.age);
		ageView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String age = (String) ageView.getItemAtPosition(position);
				List<VaccineCalendar> db = filterDB(age);
				setListAdapter(new SlideExpandableListAdapter(new VaccineCalendarAdapter(VaccineCalendarActivity.this, db), R.id.expandable_toggle_button, R.id.expandable));
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) { }
		});
		
		db = Util.GSON.fromJson(Util.loadJSON(this, "vaccine_calendar.json"), new TypeToken<List<VaccineCalendar>>() {}.getType());
		
		ageView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ageOptions));		
		setListAdapter(new SlideExpandableListAdapter(new VaccineCalendarAdapter(this, db), R.id.expandable_toggle_button, R.id.expandable));
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
		overridePendingTransition(R.anim.open_activity, R.anim.close_activity);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				break;
		}
		return false;
	}
		
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		VaccineCalendar vaccineCalendar = (VaccineCalendar) getListAdapter().getItem(position);
		Toast.makeText(this, vaccineCalendar.description, Toast.LENGTH_SHORT).show();
	}
	
	private List<VaccineCalendar> filterDB(String age){
		List<VaccineCalendar> dbFiltered = new ArrayList<VaccineCalendar>();
		for(VaccineCalendar vc : db)
			if(vc.age.equals(age))
				dbFiltered.add(vc);
		return dbFiltered;
	}
}