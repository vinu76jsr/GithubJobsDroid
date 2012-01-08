package com.vaibhavmishra.githubjobsdroid;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class JobList extends Activity{
	private String TAG = "JOBLIST";
	private Activity ctx;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joblist);
		ListView listView = (ListView)findViewById(R.id.listView1);
		ctx = this;
		List<Position> positions = Arrays.asList(Data.positions);
		listView.setAdapter(new JobListAdapter(this, R.layout.job_item, positions));
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> a, View v, int position, long id){
				Intent intent  = new Intent(ctx, JobDescription.class);
				intent.putExtra("pos", position);
				ctx.startActivity(intent);
			}
		});
	}	
}
