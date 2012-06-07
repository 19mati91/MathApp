////////////////////////////////////////////////////////////////////////////
//                                    41 Post                             //
// Android: Loading and playing videos from different sources             //
// Created by DimasTheDriver in 15/Feb/2011                               //
// Availiable at:       http://www.41post.com/?p=3024                     //
////////////////////////////////////////////////////////////////////////////

package fortyonepost.com.vv;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Intro extends Activity
{
	//the button declarations
	private Button bt_resfolder;
	private Button bt_sdcard;
	private Button bt_remoteloc;
	
	//the warning TextView
	private TextView tv_warning;
	
	//declare the intents
	private Intent i_resfolder;
	private Intent i_sdcard;
	private Intent i_remoteloc;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    { 
        //sets the Bundle
        super.onCreate(savedInstanceState);
        //sets the context 
        setContentView(R.layout.intro);
        
        //get the buttons from the layout
        bt_resfolder = (Button)findViewById(R.id.bt_resfolder);
        bt_sdcard = (Button)findViewById(R.id.bt_sdcard);
        bt_remoteloc = (Button)findViewById(R.id.bt_remoteloc);
        
        //get the TextView from the layout
        tv_warning = (TextView)findViewById(R.id.tv_warning);
        
        //instantiate the intents
    	i_resfolder = new Intent(this,PlayVideoResFolder.class);
    	i_sdcard = new Intent(this,PlayVideoSDcard.class);
    	i_remoteloc = new Intent(this,PlayVideoRemote.class);

    	//if is running from the emulator, disable the last button
        if ("sdk".equals( Build.PRODUCT ))
        {  
           bt_remoteloc.setEnabled(false);
           tv_warning.setText("Doesn\'t work on the emulator.");
        }
        else
        {
        	bt_remoteloc.setEnabled(true);
        	tv_warning.setText("");
        }
        
        //set buttons' onClickListeners
        bt_resfolder.setOnClickListener(new OnClickListener() 
        {
			public void onClick(View v) 
			{
				startActivity(i_resfolder);
			}
		});
        
        //set buttons' onClickListeners
        bt_sdcard.setOnClickListener(new OnClickListener() 
        {
			public void onClick(View v) 
			{
				startActivity(i_sdcard);
			}
		});
        
        //set buttons' onClickListeners
        bt_remoteloc.setOnClickListener(new OnClickListener() 
        {
			public void onClick(View v) 
			{
				startActivity(i_remoteloc);
			}
		});
        
    }
}