package com.MathIsFun;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class DerivativeActivity extends Activity {
    /** Called when the activity is first created. */
	private SAXParser parser;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.derivative);{
        
          	
        	
        Button derivataVideo = (Button) findViewById(R.id.DerivativeVidsID);
        Button derivataQuiz = (Button) findViewById(R.id.QuizID); 
        
        
        derivataVideo.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), DerivativeVideo.class);
				v.getContext().startActivity(myIntent);
			}
        
        });
        
        derivataQuiz.setOnClickListener(new OnClickListener() {
        	
        	public void  onClick(View v) {
        		
        		SAXParserFactory factory = SAXParserFactory.newInstance();
    	        MyDefaultHandler dh = new MyDefaultHandler();
//    	        factory.setValidating(false);
    	        try {
//    	        	factory.setFeature("http://xml.org/sax/features/validation", false);
//    	            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
//    	            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
//    	            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
//    	            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    	          parser  = factory.newSAXParser();
    	        } catch (ParserConfigurationException e) {
    	          e.printStackTrace();
    	        } catch (SAXException e) {
    	          e.printStackTrace();
    	        }

    	        try {
    	          parser.parse("http://dvweb.mah.se/m10p2713/quiz.xml", dh);
    	        } catch (SAXException e) {
    	          e.printStackTrace();
    	        } catch (IOException e) {
    	          e.printStackTrace();
    	        }
    	        
//
//    	        Log.i("TEST", (dh==null?"null":"ok"));
//    	        
//    	        Log.i("TEST", dh.getQuiz().toString());
    	        
    	
				Intent myIntent = new Intent(DerivativeActivity.this, DerivativeQuizView.class);
				myIntent.putExtra("quiz", dh.getQuiz());
				startActivity(myIntent);
				
	            
        	}
        	
        });}
        
    }
}
