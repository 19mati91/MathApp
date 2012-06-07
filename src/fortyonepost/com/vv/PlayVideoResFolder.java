////////////////////////////////////////////////////////////////////////////
//                                    41 Post                             //
// Android: Loading and playing videos from different sources             //
// Created by DimasTheDriver in 15/Feb/2011                               //
// Availiable at:       http://www.41post.com/?p=3024                     //
////////////////////////////////////////////////////////////////////////////

package fortyonepost.com.vv;

import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoResFolder extends Activity
{
	private VideoView vView;
	private String vSource;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
        //sets the Bundle
        super.onCreate(savedInstanceState);
        //sets the context 
        setContentView(R.layout.main);
        
    	//get the VideoView from the layout file
    	vView = (VideoView)findViewById(R.id.vview);

    	//use this to get touch events
        vView.requestFocus();
       
        //loads video from the Resources folder
        //set the video path
        vSource ="android.resource://fortyonepost.com.vv/" + R.raw.test30fps;
    	//set the video URI, passing the vSource as a URI
   	 	vView.setVideoURI(Uri.parse(vSource));
   	 	
   	 	//enable this if you want to enable video controllers, such as pause and forward
        vView.setMediaController(new MediaController(this));
        
        //plays the movie
        vView.start();
    }
}