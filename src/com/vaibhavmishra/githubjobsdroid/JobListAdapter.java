package com.vaibhavmishra.githubjobsdroid;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class JobListAdapter extends ArrayAdapter<Position> {
	private final String TAG = getClass().getSimpleName();
	private Activity context;
	private List<Position> positions;

	public JobListAdapter(Activity _context, int _layoutResourceId,
			List<Position> _positions) {
		super(_context, R.layout.job_item, _positions);
		positions = _positions;
		context = _context;
	}

	static class ViewHolder {
		public TextView position;
		public TextView company;
		public TextView location;
		public TextView time;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		View view = convertView;
		if (view == null) {
			LayoutInflater li = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = li.inflate(R.layout.job_item, null, true);
			holder = new ViewHolder();
			holder.position = (TextView) view
					.findViewById(R.id.job_item_position);
			holder.company = (TextView) view
					.findViewById(R.id.job_item_company_fulltime);
			holder.location = (TextView) view
					.findViewById(R.id.job_item_location);

			holder.time = (TextView) view.findViewById(R.id.job_item_time);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		final Position job_position = positions.get(position);

		if (job_position != null) {
			holder.position.setText(job_position.title);
			holder.company.setText(job_position.company);
			holder.location.setText(job_position.location.length()<20?job_position.location:(job_position.location.substring(0, 17)+"..."));
			holder.time.setText(job_position.getReadableTime());
		}

		final int pos = position;
		/*view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Intent intent  = new Intent(JobDescription.class)
			}
		});*/

		return view;
	}
}
