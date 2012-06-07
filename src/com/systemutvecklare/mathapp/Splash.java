package com.systemutvecklare.mathapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					sleep(5000); // sleeps for five seconds
					
				} catch(InterruptedException e){
					e.printStackTrace(); //For debugging, throws the exception
				}finally{
					Intent openSplash = new Intent("com.systemutvecklare.mathapp.MENU");
					startActivity(openSplash);
				}
				
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
