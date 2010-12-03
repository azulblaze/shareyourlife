package com.zhela.android.activity;

import java.util.List;

import com.zhela.android.R;
import com.zhela.android.component.AccountAdapter;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.User;

import android.os.Bundle;
import android.widget.ListView;

public class AccountList extends DefaultActivity {

	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_list);
		lv = (ListView)findViewById(R.id.listView);
		List<User> users = new SQLService().getAllUsers();
		AccountAdapter aa = new AccountAdapter(this,lv,users);
		lv.setAdapter(aa);
	}
}
