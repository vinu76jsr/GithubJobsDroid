package com.vaibhavmishra.githubjobsdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JobDescription extends Activity {
	
	private JobDescription ctx;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.job_description);
		
		ctx = this;

		int pos = getIntent().getIntExtra("pos", 0);

		WebView webview = (WebView) findViewById(R.id.webView1);
		WebSettings websettings = webview.getSettings();
		websettings.setJavaScriptEnabled(true);
		
		Position data = Data.positions[pos];

		String html = "<b><a href=" + data.company_url + ">" + data.company
				+ "</a></b><br/>" + data.description
				+ "<br/><b>How to Apply</b><br/>" + data.how_to_apply + "<br/>";
		webview.loadData(html, "text/html", "UTF-8");
	    webview.setWebViewClient( new YourWebClient()); //TODO later for setting mailto: 

	}
	
	private class YourWebClient extends WebViewClient {     
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        if (url.contains("mailto:")) {
	        	String emailAddress[] = url.split(":");
	            // TODO: extract the email... that's your work, LOL
	            String email = emailAddress[1];
	            sendEmail(email);
	            return super.shouldOverrideUrlLoading(view, url);
	        }
	        view.loadUrl(url);
	        return true;
	    }
	    
	    public void sendEmail(String email){
		    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		    emailIntent.setType("plain/text");
		    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{email});

		    String mySubject = "this is just if you want";
		    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, mySubject="");
		    String myBodyText = "this is just if you want";
		    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, myBodyText="");
		    ctx.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
		}
	}
	
	

}
