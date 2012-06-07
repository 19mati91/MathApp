package com.systemutvecklare.mathapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	String classes[] = {"MathAppActivity", "example1", "example2", "example3", "example4", "example5", "example6"}; //lesson 18
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes)); //lesson 19
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub		
		super.onListItemClick(l, v, position, id);
		String local = classes[position];
		try{
		Class ourClass = Class.forName("com.systemutvecklare.mathapp." + local); //lesson 20
		Intent ourIntent = new Intent(Menu.this, ourClass); //lesson 20
		startActivity(ourIntent); //lesson 20
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
