package com.agriculture;

import com.agriculture.R;
import com.parse.Parse;
import com.parse.PushService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		getActionBar().hide();
		  // Also in this method, specify a default Activity to handle push notifications
		
		
		new Thread() {
			public void run() {
				try{
					sleep(2000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMainActivity = new Intent("com.agriculture.MAINACTIVITY");
					startActivity(openMainActivity);
				}
			}
		}.start();
		
		
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}
