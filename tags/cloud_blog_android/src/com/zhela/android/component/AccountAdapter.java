package com.zhela.android.component;

import com.zhela.android.R;
import com.zhela.android.activity.Login;
import com.zhela.android.component.ImageCache.ImageCallback;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.User;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AccountAdapter extends BaseAdapter {

	java.util.List<User> user_list;
	private LayoutInflater mInflater;
	private View row;
	private ListView listview;
	private Activity activity;
	public AccountAdapter(Activity activity,ListView listview,java.util.List<User> user_list){
		super();
		this.user_list = user_list;
		this.listview = listview;
		this.activity = activity;
		mInflater = activity.getLayoutInflater();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		row = convertView;
		if(row==null){
			row = mInflater.inflate(R.layout.account_list_item, null);
		}
		User user = user_list.get(position);
		int pa_count = new SQLService().getUserProviderCount(user.account);
		//set name
		TextView tv = (TextView)row.findViewById(R.id.provider_account_name);
		tv.setText(user.display_name);
		tv = (TextView)row.findViewById(R.id.provider_name);
		tv.setText(pa_count+" 个帐号");
		//set image
		ImageView header = (ImageView)row.findViewById(R.id.header);
		header.setTag(user.header_url);
		ImageCache.loadImage(user.header_url,position,Image.SCALE_HEADER,
				new ImageCallback() {
					public void imageLoaded(Bitmap bitmap, 
							final int positionId, String imageUrl) {
						ImageView _header = (ImageView) listview.findViewWithTag(imageUrl);
						if (_header != null&&bitmap != null) {
							_header.setImageBitmap(bitmap);
						}
					}
				});
		ImageButton ib = (ImageButton)row.findViewById(R.id.more_action);
		ib.setTag(R.id.more_action, position);
		ib.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				User u = user_list.get(Integer.parseInt((String) arg0.getTag(R.id.more_action)));
				u.want_login = true;
				Intent login = new Intent(activity,Login.class);
				activity.startActivity(login);
			}
		});
		return row;
	}

	@Override
	public int getCount() {
		return user_list.size();
	}

	@Override
	public Object getItem(int position) {
		return user_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	

}
