package com.MathIsFun;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.R.string;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DerivativeQuizView extends Activity implements OnClickListener {

	private static final int IO_BUFFER_SIZE = 1024;
	private static final String url = null;
	private static final String TAG = null;
	private static final Bitmap bm = null;
	private static final Bitmap bitmap = null;
	// Field
	Button q1; // Answer option 1
	Button q2; // Answer option 2
	Button q3; // Answer option 3
	Button q4; // Answer option 4
	int counter;
	TextView answer1; // Displayed in the last screen of the quiz
	TextView answer2;
	TextView answer3;
	TextView answer4;
	TextView finale; // Displays total score
	TextView quizView; // A textview that displays current question
	ImageView imageView;
	Quiz q;

	int score = 0; // Increases by one for every correct answer
	private Object correctAnwer;
	private Button answer;
	private int answers;

	// Initializing
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Layout is specified and focused on, derviatesq is displayed
		setContentView(R.layout.derivatesq);
		// An object of the class Quiz is created and quiz.xml retrieved
		q = (Quiz) getIntent().getSerializableExtra("quiz"); 												
															
		Log.i("TEST", q.toString());

		quizView = (TextView) findViewById(R.id.tvQuestion1);

		imageView = (ImageView) findViewById(R.id.imageView1);
		answer = (Button) findViewById(R.id.btn1);
		answer = (Button) findViewById(R.id.btn2);
		answer = (Button) findViewById(R.id.btn3);
		answer = (Button) findViewById(R.id.btn4);
		// The textview is bound on the id which contains the correct question

		// The buttons are bound to appropriate button IDs in the layout
		q1 = (Button) findViewById(R.id.btn1);
		q1.setOnClickListener(this);
		q2 = (Button) findViewById(R.id.btn2);
		q2.setOnClickListener(this);
		q3 = (Button) findViewById(R.id.btn3);
		q3.setOnClickListener(this);
		q4 = (Button) findViewById(R.id.btn4);
		q4.setOnClickListener(this);

		Question(); // The method Question is called
	}

	private void Question() {
		// Kontrollera counter och antal frågor i q
		if(counter < 5){
		int i;
		// Om frågan finns...
		
		// TODO Auto-generated method stub
		quizView.setText(q.getQuestion(counter).question);
		imageView.setImageBitmap(getBitmapFromURL(q.getQuestion(counter).imgUrl));
		q1.setText(q.getQuestion(counter).answers[0].text);
		q2.setText(q.getQuestion(counter).answers[1].text);
		q3.setText(q.getQuestion(counter).answers[2].text);
		q4.setText(q.getQuestion(counter).answers[3].text);

		for(i = 0; i < q.getQuestion(counter).answers.length; i++){
			if (q.getQuestion(counter).answers[i].correct == true){
				correctAnwer = q.getQuestion(counter).answers[i].text;				
			}	
			}
	
		}
		else{
			Results();
		}
		
		// Annars ny intent till resultat
		// hitta den som har correct
	}
	

	public void Results() {
		setContentView(R.layout.result);
		TextView result = (TextView) findViewById(R.id.finale);
		result.setText("Your final score is: " + score + " out of " + counter);
		

//		TextView result = (TextView) findViewById(R.id.finale);
//		result.setText("Your final score is: " + counter);
//
//		TextView answer1 = (TextView) findViewById(R.id.resultview1);
//		answer1.setText("The correct answer was: -3");
//
//		TextView answer2 = (TextView) findViewById(R.id.answer2);
//		answer2.setText("The correct answer was: -6");
//
//		TextView answer3 = (TextView) findViewById(R.id.answer3);
//		answer3.setText("The correct answer was: -6");
//
//		TextView answer4 = (TextView) findViewById(R.id.answer4);
//		answer4.setText("The correct answer was: -3");
//
//		TextView answer5 = (TextView) findViewById(R.id.answer5);
//		answer5.setText("The correct answer was: -7");
		}

		

	public void onClick(View v) {
		if (v.getId() == R.id.btn1) {

		} else if (v.getId() == R.id.btn2) {

		} else if (v.getId() == R.id.btn3) {

		} else if (v.getId() == R.id.btn4) {

		}
		
		Button b = (Button) v;
		boolean answer_was_correct = b.getText().toString().equals(correctAnwer);
		
		counter++;
		//score++;
		Question(); // The method Question1 is called
	}
	
	public static Bitmap getBitmapFromURL(String src) {
		try {
			Log.e("src", src);
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			Log.e("Bitmap", "returned");
			return myBitmap;
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Exception", e.getMessage());
			return null;
		}
	}

	private static void copy(InputStream in, BufferedOutputStream out) {
		// TODO Auto-generated method stub

	}

	private static void closeStream(BufferedOutputStream out) {
		// TODO Auto-generated method stub

	}

	private static void closeStream(InputStream in) {
		// TODO Auto-generated method stub

	}

}

// gör en layout för texview
// Log.i("quizview", q.getQuestion(1) );
// printa ut xml texten i QuizView. efter den har parsat-

