package com.adrielcafe.vacinarecife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.adrielcafe.vacinarecife.adapter.VaccineCalendarAdapter;
import com.adrielcafe.vacinarecife.model.VaccinationUnit;
import com.adrielcafe.vacinarecife.model.VaccineCalendar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.reflect.TypeToken;
import com.tjerkw.slideexpandable.library.SlideExpandableListAdapter;

import android.R.drawable;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class VaccinationUnitsActivity extends Activity {	
	private List<VaccinationUnit> db;
	private GoogleMap map;
	private Spinner districtView;
	private String[] districtOptions;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		overridePendingTransition(R.anim.open_activity, R.anim.close_activity);
		setContentView(R.layout.activity_units);
		getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));
		getActionBar().setDisplayHomeAsUpEnabled(true);

		db = Util.GSON.fromJson(Util.loadJSON(this, "vaccination_unit.json"), new TypeToken<List<VaccinationUnit>>() {}.getType());
		districtOptions = getDistrictOptions(db);
		
		districtView = (Spinner) findViewById(R.id.district);
		districtView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, districtOptions));
		districtView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String district = (String) districtView.getItemAtPosition(position);
				selectDistrict(district);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) { }
		});
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(Util.LAT_LNG_RECIFE, 13));
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
	
	private String[] getDistrictOptions(List<VaccinationUnit> db){
		Set<String> options = new HashSet<String>();
		for(VaccinationUnit vu : db)
			options.add(vu.district);
		
		List<String> optionsList = new ArrayList<String>(options);
		Collections.sort(optionsList);
		return optionsList.toArray(new String[optionsList.size()]);
	}
	
	private void selectDistrict(String district){
		map.clear();
		
		for(VaccinationUnit vu : db)
			if(vu.district.equals(district))
				try {
					map.addMarker(new MarkerOptions()
		            .title(vu.unit) 
		            .snippet(vu.address)
		            .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_marker)))
		            .position(new LatLng(Double.parseDouble(vu.latitude.replace(",", ".")), Double.parseDouble(vu.longitude.replace(",", ".")))));
				} catch (Exception e) { }
		
		LatLng latLng = Util.LAT_LNG_RECIFE_DISTRICTS.get(district);
		if(latLng != null)
			map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
	}
}