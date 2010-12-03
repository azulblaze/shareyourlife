package com.zhela.android.component;

import com.zhela.android.R;
import com.zhela.android.component.ImageCache.ImageCallback;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.Provider;
import com.zhela.android.core.db.model.ProviderAccount;

import android.app.Activity;
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

public class ProviderAccountAdapter extends BaseAdapter {

	java.util.List<ProviderAccount> provider_account_list;
	private LayoutInflater mInflater;
	private View row;
	private ListView listview;
	public ProviderAccountAdapter(Activity activity,ListView listview,java.util.List<ProviderAccount> provider_account_list){
		super();
		this.provider_account_list = provider_account_list;
		this.listview = listview;
		mInflater = activity.getLayoutInflater();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		row = convertView;
		if(row==null){
			row = mInflater.inflate(R.layout.account_info_item, null);
		}
		ProviderAccount provider_account = provider_account_list.get(position);
		Provider provider = new SQLService().loadProviderById(provider_account.provider_id);
		//set name
		TextView tv = (TextView)row.findViewById(R.id.provider_account_name);
		tv.setText(provider_account.provider_userName);
		if(provider!=null){
			tv = (TextView)row.findViewById(R.id.provider_name);
			tv.setText(provider.name);
		}
		//set image
		ImageView header = (ImageView)row.findViewById(R.id.header);
		header.setTag(provider_account.provider_userHeader);
		ImageCache.loadImage(provider_account.provider_userHeader,position,Image.SCALE_HEADER,
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
				System.out.println(arg0.getTag(R.id.more_action));
			}
			
		});
		return row;
	}

	@Override
	public int getCount() {
		return provider_account_list.size();
	}

	@Override
	public Object getItem(int position) {
		return provider_account_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	

}
