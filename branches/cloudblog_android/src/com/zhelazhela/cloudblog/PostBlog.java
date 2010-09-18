package com.zhelazhela.cloudblog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PostBlog extends Activity {
    /** Called when the activity is first created. */
	private Button cancel;
	private Button post;
	private EditText et;
	private static String inputText = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.postblog);
        cancel = (Button)findViewById(R.id.cancel);
        et = (EditText)findViewById(R.id.post_content);
        if(inputText!=null){
        	et.setText(inputText);
        }
        cancel.setOnClickListener(new OnClickListener(){public void onClick(View v){
        	inputText = et.getText().toString();
        	finish();
        }});
    }
    
}