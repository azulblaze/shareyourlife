package com.zhela.android.activity;

import com.zhela.android.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Index extends DefaultActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.index);
		Button logout = (Button)findViewById(R.id.cancel_button);
		logout.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent login = new Intent(Index.this,Login.class);
				startActivity(login);
			}
			
		});
	}

}
