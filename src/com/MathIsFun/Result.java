package com.MathIsFun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result {
	
	// G�r en listView f�r utskriften av de felaktiga svaren
	// G�r en for loop som loopar genom wronglist och matar in v�rdena i listView
	
	public class NextActivity extends Activity {
		// Called when the activity is first created.
		public void onCreate(Bundle savedInstanceState, String counter, String score) {
			
			setContentView(R.layout.result);
			TextView result = (TextView) findViewById(R.id.finale);
			result.setText("Your final score is: " + score + " out of " + counter);
			
			
		}
		
		}
	
	
	
	

	

}
