package com.adrielcafe.vacinarecife.adapter;

import java.util.List;

import com.adrielcafe.vacinarecife.R;
import com.adrielcafe.vacinarecife.model.VaccineCalendar;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VaccineCalendarAdapter extends ArrayAdapter<VaccineCalendar>{
	
	public VaccineCalendarAdapter(Context context, List<VaccineCalendar> objects) {
		super(context, R.layout.list_item_vaccine, objects);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		VaccineCalendar vaccineCalendar = getItem(position);
		ViewHolder viewHolder;

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_vaccine, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.vaccineName = (TextView) convertView.findViewById(R.id.vaccineName);
			viewHolder.description = (TextView) convertView.findViewById(R.id.description);
			viewHolder.dosage = (TextView) convertView.findViewById(R.id.dosage);
			viewHolder.dosageQuantity = (TextView) convertView.findViewById(R.id.dosageQuantity);
			viewHolder.way = (TextView) convertView.findViewById(R.id.way);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.vaccineName.setText(vaccineCalendar.vaccineName);

		if(vaccineCalendar.dosage == null || vaccineCalendar.dosage.isEmpty())
			viewHolder.dosage.setVisibility(View.GONE);
		else
			viewHolder.dosage.setText(Html.fromHtml("<b>Dosagem:</b><br>" + vaccineCalendar.dosage));

		if(vaccineCalendar.dosageQuantity == null || vaccineCalendar.dosageQuantity.isEmpty())
			viewHolder.dosageQuantity.setVisibility(View.GONE);
		else
			viewHolder.dosageQuantity.setText(Html.fromHtml("<b>Quantidade:</b><br>" + vaccineCalendar.dosageQuantity));
			
		if(vaccineCalendar.way == null || vaccineCalendar.way.isEmpty())
			viewHolder.way.setVisibility(View.GONE);
		else
			viewHolder.way.setText(Html.fromHtml("<b>Via de Administração:</b><br>" + vaccineCalendar.way));

		if(vaccineCalendar.description == null || vaccineCalendar.description.isEmpty())
			viewHolder.description.setVisibility(View.GONE);
		else
			viewHolder.description.setText(Html.fromHtml("<b>Descrição:</b><br>" + vaccineCalendar.description));
		
		return convertView;
	}

	private class ViewHolder {
		TextView vaccineName;
		TextView description;
		TextView dosage;
		TextView dosageQuantity;
		TextView way;
	}
}