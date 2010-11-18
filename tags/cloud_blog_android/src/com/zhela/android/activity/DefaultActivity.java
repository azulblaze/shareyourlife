package com.zhela.android.activity;

import java.util.HashMap;
import java.util.Map;

import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;

import android.app.Activity;
import android.content.Context;

public class DefaultActivity extends Activity {

	public static Map<String,Context> context_map = new HashMap<String,Context>();
	public static boolean exit = false;
	@Override
	protected void onStart() {
		super.onStart();
		String packageName =  this.getClass().getName();
		context_map.put(packageName,  this);
	}

	@Override
	protected void onStop() {
		cleanContext();
		String name = this.getClass().getName();
		if(context_map.keySet().size()<=1&&context_map.containsKey(name)){
			exitWEB();
		}
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		cleanContext();
		String name = this.getClass().getName();
		if(context_map.keySet().size()<=1&&context_map.containsKey(name)){
			exitWEB();
		}
		super.onDestroy();
		context_map.remove(name);
	}
	
	private void cleanContext(){
		Context tmp;
		for(String key:context_map.keySet()){
			tmp = context_map.get(key);
			if(tmp==null){
				context_map.remove(key);
			}
		}
	}

	private synchronized void exitWEB(){
		if(!exit){
			exit= true;
			Service service = new ServiceImpl();
			try{
				service.shutdownApp();
			}catch(Exception e){
			}
		}
	}
	
}
