package com.systemutvecklare.mathapp;

import android.app.Activity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


public class Derivates extends Activity{

 String myVideo = "rtsp://www.khanacademy.org/math/calculus/v/partial-derivatives";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.derivates);
		VideoView myVideoView = (VideoView)findViewById(R.id.myvideoview);
		myVideoView.setVideoURI(Uri.parse(myVideo));
		myVideoView.setMediaController(new MediaController(this));
		myVideoView.requestFocus();
		myVideoView.start();
		
		
	}

}
