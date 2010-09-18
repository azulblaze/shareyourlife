package com.zhelazhela.cloudblog.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class TransActivityListener implements OnClickListener{
	public static Class<?> lastClass;
	private Context packageContext;
	private Class<?> cls;
	public Class<?> _lastClass;
	public TransActivityListener(Context packageContext, Class<?> cls, Class<?> last){
		this.packageContext = packageContext;
		this.cls = cls;
		this._lastClass = last;
	}
	
	public void onClick(View v) {
		Intent trans = new Intent(packageContext,cls);
		lastClass = _lastClass;
		packageContext.startActivity(trans);
	}
}
