package com.MathIsFun;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;


public class DerivativeVideo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.derivativevideo);
		
		VideoView myVideo = (VideoView) findViewById(R.id.DerivativeVidsID1);
		
		String viewSource = "rtsp://v7.cache5.c.youtube.com/CjgLENy73wIaLwm-HLfEpJXcABMYDSANFEIJbXYtZ29vZ2xlSARSB3Jlc3VsdHNg7fKGn4SIo9VPDA==/0/0/0/video.3gp";
		
		 
		myVideo.setVideoURI(Uri.parse(viewSource));
	    myVideo.setMediaController(new MediaController(this));
	    myVideo.requestFocus();
	    myVideo.start();

	}
}

