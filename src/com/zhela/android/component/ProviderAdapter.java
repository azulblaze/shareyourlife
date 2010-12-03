package com.zhela.android.component;

import com.zhela.android.R;
import com.zhela.android.activity.ProviderAccountAdd;
import com.zhela.android.component.ImageCache.ImageCallback;
import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.Provider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ProviderAdapter extends BaseAdapter {

	java.util.List<Provider> provider_list;
	private LayoutInflater mInflater;
	private View row;
	private ListView listview;
	private Activity activity;
	public ProviderAdapter(Activity activity,ListView listview,java.util.List<Provider> provider_list){
		super();
		this.provider_list = provider_list;
		this.listview = listview;
		this.activity = activity;
		mInflater = activity.getLayoutInflater();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		row = convertView;
		if(row==null){
			row = mInflater.inflate(R.layout.provider_list_item, null);
		}
		Provider provider = provider_list.get(position);
		row.setTag(provider);
		//set image
		ImageView logo = (ImageView)row.findViewById(R.id.logo);
		logo.setTag(R.id.header,provider.logo);
		ImageCache.loadImage(provider.logo,position,Image.SCALE_HEADER,
				new ImageCallback() {
					public void imageLoaded(Bitmap bitmap, 
							final int positionId, String imageUrl) {
						ImageView _header = (ImageView) listview.findViewWithTag(imageUrl);
						if (_header != null&&bitmap != null) {
							_header.setImageBitmap(bitmap);
						}
					}
				});
		row.setOnClickListener(add_account_listener);
		return row;
	}

	@Override
	public int getCount() {
		return provider_list.size();
	}

	@Override
	public Object getItem(int position) {
		return provider_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	

	private OnClickListener add_account_listener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Provider provider = (Provider)arg0.getTag();
			Intent add_account = new Intent(activity,ProviderAccountAdd.class);
			add_account.putExtra("provider", provider);
			activity.startActivity(add_account);
		}
	};
}
