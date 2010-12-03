package com.zhela.android.activity;

import com.zhela.android.R;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccountReg extends DefaultActivity{

	private EditText account_input;
	private EditText account_password;
	private EditText account_repassword;
	private EditText account_name;
	private EditText account_email;
	private Button reg_button;
	private TextView notice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reg);
		account_input = (EditText)findViewById(R.id.login_account_input);
		account_password = (EditText)findViewById(R.id.login_password_input);
		account_repassword = (EditText)findViewById(R.id.re_login_password_input);
		account_name = (EditText)findViewById(R.id.reg_nickname_input);
		account_email = (EditText)findViewById(R.id.reg_email_input);
		reg_button = (Button)findViewById(R.id.login_button);
		notice = (TextView)findViewById(R.id.notice_text);
		reg_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String input_text = account_input.getText().toString();
				if(!UtilInfo.StringFilter(input_text)||input_text.trim().length()<3||input_text.trim().length()>20){
					notice.setText("帐号由大于3小于20的英文和数字组成");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String account = input_text;
				input_text = account_password.getText().toString();
				if(!UtilInfo.PasswordFilter(input_text)||input_text.trim().length()<6||input_text.trim().length()>16){
					notice.setText("密码由大于6小于16的英文字符组成");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				if(!account_repassword.getText().toString().equals(input_text)){
					notice.setText("前后两次输入的密码不一样");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String password = input_text;
				input_text = account_name.getText().toString();
				if(!UtilInfo.NameFilter(input_text)||input_text.trim().length()<2||input_text.trim().length()>16){
					notice.setText("用户名由2-16个中文字英文数字组成");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String name = input_text;
				input_text = account_email.getText().toString();
				if(!UtilInfo.EmailFilter(input_text)){
					notice.setText("E-mail格式不正确");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String email = input_text;
				Service service = new ServiceImpl();
				try {
					RESTInternalUser regUser = service.regUser(account, password, email, name);
					if(regUser!=null){
						UtilInfo.loginusers.is_default = true;
						UtilInfo.loginusers.want_login = false;
						UtilInfo.loginusers.account = regUser.getAccount();
						UtilInfo.loginusers.account_password = password;
						UtilInfo.loginusers.is_password = true;
						UtilInfo.loginusers.display_name = regUser.getDisplayName();
						UtilInfo.loginusers.email = regUser.getEmail();
						UtilInfo.loginusers.header_url = regUser.getHeader();
						UtilInfo.loginusers.update_time = regUser.getUpdateTime();
						SQLService sqls = new SQLService();
						sqls.updateOrInsertUser(UtilInfo.loginusers,null, null);
						Intent provider_list = new Intent(AccountReg.this,ProviderList.class);
						startActivity(provider_list);
					}else{
						notice.setText("发生错误,注册失败");
						notice.setVisibility(View.VISIBLE);
					}
				} catch (DefaultException e) {
					notice.setText(e.getMessage());
					notice.setVisibility(View.VISIBLE);
					//progeress.dismiss();
					return;
				}
			}
			
		});
	}

}
