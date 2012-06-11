package com.MathIsFun;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity {
	
	// Gör en listView för utskriften av de felaktiga svaren
	// Gör en for loop som loopar genom wronglist och matar in värdena i listView
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		TextView result = (TextView) findViewById(R.id.finale);
		result.setText("Your final score is: " + score + " out of " + counter);
	}
	
}
