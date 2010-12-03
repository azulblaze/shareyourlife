package com.zhela.android.activity;

import com.zhela.android.R;
import com.zhela.android.component.ImageCache;
import com.zhela.android.component.ImageCache.ImageCallback;
import com.zhela.android.core.db.SQLiteFactory;
import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.Provider;
import com.zhela.android.core.db.model.ProviderAccount;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTProviderAccount;
import com.zhela.android.core.remote.model.RESTUser;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * User can add the provider account in here. After success, will return to user's provider account list page.
 * @author chennyan
 *
 */
public class ProviderAccountAdd extends DefaultActivity{

	private EditText account_input;
	private EditText account_password;
	private TextView notice;
	private Button valid_button;
	private ImageView logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider_account_add);
		account_input = (EditText) findViewById(R.id.login_account_input);
		account_password = (EditText) findViewById(R.id.login_password_input);
		notice = (TextView) findViewById(R.id.notice_text);
		valid_button = (Button) findViewById(R.id.login_button);
		logo = (ImageView) findViewById(R.id.logo);
		final Provider select_provider = (Provider)this.getIntent().getExtras().getSerializable("provider");
		ImageCache.loadImage(select_provider.logo, 0, Image.TYPE_WEIBO, new ImageCallback() {
			public void imageLoaded(Bitmap bitmap, 
					final int positionId, String imageUrl) {
				if (bitmap != null) {
					logo.setImageBitmap(bitmap);
				}
			}
		});
		
		valid_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String input_text = account_input.getText().toString();
				if(input_text==null||input_text.trim().length()==0){
					notice.setText("请输入你的微博帐号");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String providerAccount = input_text;
				input_text = account_password.getText().toString();
				if(input_text==null||input_text.trim().length()==0){
					notice.setText("请输入你的微博密码");
					notice.setVisibility(View.VISIBLE);
					return;
				}
				String password = input_text;
				Service service = new ServiceImpl();
				try {
					RESTProviderAccount providerUser = service.postProviderAccount(select_provider.id, providerAccount, password);
					if(providerUser!=null){
						ProviderAccount pa = new ProviderAccount();
						pa.account = UtilInfo.loginusers.account;
						pa.provider_account = providerUser.getProviderAccount();
						pa.provider_id = providerUser.getProviderId();
						pa.provider_userId = providerUser.getProviderUserId();
						try{
							RESTUser restUser = service.getUserInfo(pa.provider_id, pa.provider_account,pa.provider_userId );
							pa.provider_userHeader = restUser.getHeader().getThumb();
							pa.provider_userName = restUser.getName();
						}catch(Exception e){
							
						}
						pa.update_time = providerUser.getUpdateTime();
						pa.status = providerUser.getStatus();
						UtilInfo.addProviderAccount(pa);
						SQLiteFactory.getInstance().saveModel(pa);
						Intent account_info = new Intent(ProviderAccountAdd.this,AccountInfo.class);
						startActivity(account_info);
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
