package com.zhelazhela.cloudblog;

import com.zhelazhela.cloudblog.listener.TransActivityListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Welcome extends Activity {
	private Button startapp;
	private Button postblog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startapp = (Button)findViewById(R.id.startapp);
        startapp.setOnClickListener(new TransActivityListener(Welcome.this,BlogList.class,Welcome.class));
        
        postblog = (Button)findViewById(R.id.postblog);
        postblog.setOnClickListener(new TransActivityListener(Welcome.this,PostBlog.class,Welcome.class));
    }
    
}