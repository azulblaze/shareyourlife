package com.zhela.android.activity;

import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.zhela.android.R;
import com.zhela.android.component.ProviderAdapter;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.Provider;

/**
 * display all the user's provider account, also need to display the account status, can delete the provider account
 * Can also delete this user's account in this page
 * @author chennyan
 *
 */
public class ProviderList extends DefaultActivity{

	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider_list);
		lv = (ListView)findViewById(R.id.listView);
		List<Provider> providers = new SQLService().loadAllProviders();
		ProviderAdapter aa = new ProviderAdapter(this,lv,providers);
		lv.setAdapter(aa);
	}
	
}
