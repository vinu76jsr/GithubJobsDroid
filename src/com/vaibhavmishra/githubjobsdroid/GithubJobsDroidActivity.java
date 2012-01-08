package com.vaibhavmishra.githubjobsdroid;

import java.lang.reflect.Type;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GithubJobsDroidActivity extends Activity {
	/** Called when the activity is first created. */
	private String TAG = "MAIN";
	private EditText description;
	private EditText location;
	private ToggleButton fulltime;
	private ProgressBar progressBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button submit = (Button) findViewById(R.id.main_submit);
		description = (EditText) findViewById(R.id.main_description);
		location = (EditText) findViewById(R.id.main_location);
		fulltime = (ToggleButton) findViewById(R.id.main_fulltime);
		progressBar = (ProgressBar)findViewById(R.id.main_progressBar1);

		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				progressBar.setVisibility(View.VISIBLE);
				GithubJobsRestClient.get("positions.json", setParams(),
						new AsyncHttpResponseHandler() {
							@Override
							public void onSuccess(String response){
								Log.i(TAG, response);
								Gson gson = new Gson();
								Type positionsType = new TypeToken<Position[]>(){}.getType();
								Data.positions = gson.fromJson(response, positionsType);
								progressBar.setVisibility(View.GONE);
								startActivity(new Intent(GithubJobsDroidActivity.this, JobList.class));
							}
						});
			}
		});

		Log.d(TAG, "");
	}

	private RequestParams setParams() {
		RequestParams params = new RequestParams();
		if (description.getEditableText() != null) {
			params.put("description", description.getEditableText().toString());
		}
		if (location.getEditableText() != null) {
			params.put("location", location.getEditableText().toString());
		}
		params.put("full_time", fulltime.isChecked() ? "true" : "false");

		return params;
	}
}