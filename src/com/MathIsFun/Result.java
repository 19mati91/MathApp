package com.MathIsFun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result {
	
	// Gör en listView för utskriften av de felaktiga svaren
	// Gör en for loop som loopar genom wronglist och matar in värdena i listView
	
	public class NextActivity extends Activity {
		// Called when the activity is first created.
		public void onCreate(Bundle savedInstanceState, String counter, String score) {
			
			setContentView(R.layout.result);
			TextView result = (TextView) findViewById(R.id.finale);
			result.setText("Your final score is: " + score + " out of " + counter);
			
			
		}
		
		}
	
	
	
	

	

}
