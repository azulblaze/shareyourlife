package com.zhela.android.activity;

import java.util.List;

import com.zhela.android.R;
import com.zhela.android.component.ProviderAccountAdapter;
import com.zhela.android.core.db.SQLiteFactory;
import com.zhela.android.core.db.model.ProviderAccount;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTProviderAccount;
import com.zhela.android.core.remote.model.RESTProviderAccountList;
import com.zhela.android.core.remote.model.RESTUser;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

/**
 * User can add the provider account in here. After success, will return to user's provider account list page.
 * @author chennyan
 *
 */
public class AccountInfo extends DefaultActivity{

	private ListView lv;
	private ProviderAccountAdapter paa;
	private Button add_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_info);
		Button refresh = (Button)findViewById(R.id.refresh);
		add_button = (Button)findViewById(R.id.add_button);
		add_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent provider_list = new Intent(AccountInfo.this,ProviderList.class);
				startActivity(provider_list);
			}
			
		});
		refresh.setOnClickListener(refresh_listener);
		lv = (ListView)findViewById(R.id.listView);
		paa = new ProviderAccountAdapter(this,lv,UtilInfo.provider_account);
		lv.setAdapter(paa);
	}
	
	private OnClickListener refresh_listener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Service service = new ServiceImpl();
			try {
				RESTProviderAccountList list = service.getUserProviderAccount();
				if(list!=null&&list.getProviderAccounts()!=null){
					List<RESTProviderAccount>  _list = list.getProviderAccounts();
					ProviderAccount pa;
					for(RESTProviderAccount rest:_list){
						pa = new ProviderAccount();
						pa.account = UtilInfo.loginusers.account;
						pa.provider_account = rest.getProviderAccount();
						pa.provider_id = rest.getProviderId();
						pa.provider_userId = rest.getProviderUserId();
						pa.provider_userName = null;
						pa.status = rest.getStatus();
						pa.update_time = rest.getUpdateTime();
						try{
							RESTUser restUser = service.getUserInfo(rest.getProviderId(), rest.getProviderAccount(), rest.getProviderUserId());
							pa.provider_userHeader = restUser.getHeader().getThumb();
							pa.provider_userName = restUser.getName();
						}catch(Exception e){
							
						}
						UtilInfo.addProviderAccount(pa);
						SQLiteFactory.getInstance().saveModel(pa);
					}
					paa = new ProviderAccountAdapter(AccountInfo.this,lv,UtilInfo.provider_account);
					lv.setAdapter(paa);
				}
			} catch (DefaultException e) {
				
			}
		}
		
	};
}
