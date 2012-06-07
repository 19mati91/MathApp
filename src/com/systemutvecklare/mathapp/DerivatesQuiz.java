package com.systemutvecklare.mathapp;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class DerivatesQuiz extends Activity{
	
	//Fields
	Button previous;
	Button next;
	TextView question; // Displays the questions up top
	RadioButton leftMost; // The radiobuttons from left to right
	RadioButton middleLeft;
	RadioButton middleRight;
	RadioButton rightMost;
	TextView score; // Displays the score at the end of quiz
	int counter; // Increases by one for every correct answer
	string[] questions; // Unused list, intended 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.derivatesquiz);
		
		previous = (Button) findViewById(R.id.btnPrev);
		next = (Button) findViewById(R.id.btnNext);
		question = (TextView) findViewById(R.id.tvQuestion);
		leftMost = (RadioButton) findViewById(R.id.rbtn1);
		middleLeft = (RadioButton) findViewById(R.id.rbtn2);
		middleRight = (RadioButton) findViewById(R.id.rbtn3);
		rightMost = (RadioButton) findViewById(R.id.rbtn4);
		score = (TextView) findViewById(R.id.tvDisplayScoreFinal);
		counter = 0;
		
		next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (middleLeft.isChecked()) {
					counter++;
				}
				setContentView(R.layout.dq2);
			}			
		});
	}
}
