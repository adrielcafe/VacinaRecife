package com.adrielcafe.vacinarecife;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(Html.fromHtml("<b>Vacina</b> Recife"));
		getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_about) {
			Util.showDialog(this, getString(R.string.about), Util.ABOUT_MESSAGE);
		}
		return super.onOptionsItemSelected(item);
	}

	public void openVaccineCalendar(View v){
		startActivity(new Intent(this, VaccineCalendarActivity.class));
	}
	
	public void openVaccinationUnits(View v){
		startActivity(new Intent(this, VaccinationUnitsActivity.class));
	}
}