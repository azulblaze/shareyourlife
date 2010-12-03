package com.zhela.android.activity;

import java.util.HashSet;
import java.util.Set;

import com.zhela.android.R;
import com.zhela.android.component.ConfigureLoad;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.User;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Login extends DefaultActivity {
	private EditText account_input;
	private EditText account_password;
	private CheckBox account_savepassword;
	private ProgressDialog progeress;
	private TextView notice;
	private boolean updateDB = false;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        progeress = new ProgressDialog(this);
        account_input = (EditText)findViewById(R.id.login_account_input);
        account_password = (EditText)findViewById(R.id.login_password_input);
        account_savepassword = (CheckBox)findViewById(R.id.savepassword_input);
        notice = (TextView)findViewById(R.id.notice_text);
        Button cancel = (Button)this.findViewById(R.id.cancel_button);
        cancel.setOnClickListener(cancel_listener);
        Button reg = (Button)this.findViewById(R.id.reg_button);
        reg.setOnClickListener(reg_listener);
        Button login_button = (Button)this.findViewById(R.id.login_button);
        account_input.addTextChangedListener(account_input_watcher);
        account_password.addTextChangedListener(account_password_watcher);
        account_savepassword.setOnCheckedChangeListener(savepassword_check_listener);
        login_button.setOnClickListener(login_button_listener);
        if(UtilInfo.loginusers!=null){
        	account_input.setText(UtilInfo.loginusers.account);
        	if(UtilInfo.loginusers.account!=null){
        		int _len = account_input.getEditableText().length();
            	Selection.setSelection(account_input.getEditableText(), _len);
        	}
        	account_password.setText(UtilInfo.loginusers.account_password);
        	account_savepassword.setChecked(UtilInfo.loginusers.is_password);
        	updateDB = false;
        	if(UtilInfo.loginusers.want_login&&UtilInfo.loginusers.is_password){
        		login();
        	}
        }
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}







	private OnClickListener reg_listener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Intent reg = new Intent(Login.this,AccountReg.class);
			Login.this.startActivity(reg);
		}
    };
    private OnClickListener cancel_listener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Intent list = new Intent(Login.this,AccountList.class);
			Login.this.startActivity(list);
		}
    };
    private TextWatcher account_input_watcher = new TextWatcher(){
		@Override
		public void afterTextChanged(Editable arg0) {
			updateDB = true;
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}
    };
    private TextWatcher account_password_watcher = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			updateDB = true;
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}
		
    };
    private OnClickListener login_button_listener = new OnClickListener(){
		@Override
		public void onClick(View v) {
			login();
		}
    };
    private OnCheckedChangeListener savepassword_check_listener = new OnCheckedChangeListener(){
		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			updateDB = true;
		}
    };
    
    private void login(){
    	UtilInfo.provider_account = null;
    	notice.setVisibility(View.GONE);
    	progeress.setTitle(R.string.default_load_text);
		String account_input_str = account_input.getText().toString();
		String account_password_str = account_password.getText().toString();
		if(UtilInfo.loginusers==null){
    		UtilInfo.loginusers = new User();
    		UtilInfo.loginusers.is_default = false;
    	}
		if(!UtilInfo.StringFilter(account_input_str)||account_input_str.trim().length()<3){
			notice.setText("帐号由大于3小于20的英文和数字组成");
			notice.setVisibility(View.VISIBLE);
			return;
		}
		if(!UtilInfo.PasswordFilter(account_password_str)||account_password_str.trim().length()<6){
			notice.setText("密码由大于6小于16的英文字符组成");
			notice.setVisibility(View.VISIBLE);
			return;
		}
		progeress.show();
		Service service = new ServiceImpl();
		try {
			RESTInternalUser myuser = service.login(account_input_str, account_password_str);
			UtilInfo.loginusers.want_login = false;
			UtilInfo.loginusers.account = myuser.getAccount();
			UtilInfo.loginusers.account_password = account_password_str;
			UtilInfo.loginusers.is_password = account_savepassword.isChecked();
			UtilInfo.loginusers.display_name = myuser.getDisplayName();
			UtilInfo.loginusers.email = myuser.getEmail();
			UtilInfo.loginusers.header_url = myuser.getHeader();
			UtilInfo.loginusers.update_time = myuser.getUpdateTime();
			ConfigureLoad cl = new ConfigureLoad(Login.this);
			cl.loadProviders();
			if(!UtilInfo.loginusers.is_default||updateDB){
				SQLService sqls = new SQLService();
				sqls.reSetDefaultUser();
				UtilInfo.loginusers.is_default = true;
				Set<String> field = new HashSet<String>();
				field.add("account_password");
				field.add("is_password");
				field.add("header_url");
				field.add("is_default");
				sqls.updateOrInsertUser(UtilInfo.loginusers, " account='"+UtilInfo.loginusers.account+"'", null);
			}
			
			UtilInfo.provider_account = new SQLService().loadProviderAccount(UtilInfo.loginusers.account);
			if(UtilInfo.provider_account.size()==0){
				Intent accountinfo = new Intent(Login.this,AccountInfo.class);
				progeress.dismiss();
				Login.this.startActivity(accountinfo);
			}else{
				Intent index = new Intent(Login.this,Index.class);
				progeress.dismiss();
				Login.this.startActivity(index);
			}
		} catch (DefaultException e) {
			if(e.getAction()==DefaultException.NEEDLOGIN){
				notice.setText("登录失败,请检查您的帐号和密码");
				notice.setVisibility(View.VISIBLE);
				progeress.dismiss();
				return;
			}
		}
		if(progeress.isShowing()){
			progeress.dismiss();
		}
    }
}
