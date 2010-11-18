package com.zhela.android.activity;

import com.zhela.android.R;
import com.zhela.android.core.db.Users;
import com.zhela.android.core.util.UtilInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends DefaultActivity {
	public static Users loginUser;
	private EditText account_input;
	private EditText account_password;
	TextView notice;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        account_input = (EditText)findViewById(R.id.login_account_input);
        account_password = (EditText)findViewById(R.id.login_password_input);
        notice = (TextView)findViewById(R.id.notice_text);
        Button cancel = (Button)this.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent list = new Intent(Login.this,AccountList.class);
				Login.this.startActivity(list);
			}
        });
        Button reg = (Button)this.findViewById(R.id.reg_button);
        reg.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent reg = new Intent(Login.this,RegAccount.class);
				Login.this.startActivity(reg);
			}
        });
        Button login_button = (Button)this.findViewById(R.id.login_button);
        account_input.setOnKeyListener(new OnKeyListener(){

			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				if(arg2.getAction()==KeyEvent.ACTION_UP){
					String account_input_str = account_input.getText().toString();
					account_input.setText(FilterStr(account_input_str));
				}
				return false;
			}
			
			
        });
        account_password.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String account_password_str = account_password.getText().toString();
				account_password_str = account_password_str.length()>16?account_password_str.substring(0,16):account_password_str;
				account_password.setText(FilterStr(account_password_str));
			}
        	
        });
        login_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				notice.setVisibility(View.GONE);
				String account_input_str = account_input.getText().toString();
				String account_password_str = account_password.getText().toString();
				if(account_input_str==null||account_input_str.trim().length()<6){
					notice.setText("帐号由大于6小于20的英文和数字组成");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				if(account_password_str==null||account_password_str.trim().length()<6){
					notice.setText("密码由大于6小于16的英文和数字组成");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				
			}
        	
        });
	}
	
	private String FilterStr(String str){
		str = UtilInfo.StringFilter(str);
		str = str.length()>20?str.substring(0,20):str;
		return str;
	}
}
