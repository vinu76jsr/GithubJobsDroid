package com.vaibhavmishra.githubjobsdroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class JobDescription extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.job_description);

		int pos = getIntent().getIntExtra("pos", 0);

		WebView webview = (WebView) findViewById(R.id.webView1);
		Position data = Data.positions[pos];

		String html = "<b><a href=" + data.company_url + ">" + data.company
				+ "</a></b><br/>" + data.description
				+ "<br/><b>How to Apply</b><br/>" + data.how_to_apply + "<br/>";
		webview.loadData(html, "text/html", "UTF-8");

	}
}
