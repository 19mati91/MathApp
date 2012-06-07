package com.MathIsFun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MathIsFunActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);{
        	
        	
        Button derivata = (Button) findViewById(R.id.DerivataID);
        derivata.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
				Intent myIntent = new Intent(MathIsFunActivity.this, DerivativeActivity.class);
				v.getContext().startActivity(myIntent);
			}
        
        });}
    }
}