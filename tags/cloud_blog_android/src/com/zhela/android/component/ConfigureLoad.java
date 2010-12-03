package com.zhela.android.component;

import java.util.List;

import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.SQLiteFactory;
import com.zhela.android.core.db.SQLiteSupport;
import com.zhela.android.core.db.model.Provider;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTProvider;
import com.zhela.android.core.remote.model.RESTProviderList;
import com.zhela.android.core.util.DeviceInfo;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;

public class ConfigureLoad {

	private Context context;
	
	public ConfigureLoad(Context context){
		this.context = context;
	}
	
	public void loadServerInfo() throws NameNotFoundException{
		PackageManager manager = context.getPackageManager();
		ApplicationInfo info = manager.getApplicationInfo(context.getPackageName(), 128);
		if (info != null){
			 ServiceImpl.BASE_URL = info.metaData.getString("BOLE_SERVER");
		}
	}
	
	public void loadDeviceInfo(){
		TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		new DeviceInfo().getInfo(tm);
	}
	
	public void initDB(){
		SQLiteSupport sqlHelper = new SQLiteSupport(context,"bole.db",null,UtilInfo.bole_version);  
		SQLiteFactory.instance = sqlHelper;
	}
	
	public void loadProviders(){
		if(new SQLService().loadAllProviders().size()==0){
			RefreshProviders();
		}
	}
	
	public void RefreshProviders(){
		Service service = new ServiceImpl();
		try {
			RESTProviderList list = service.getAllProviders();
			List<RESTProvider> restlist =  list.getProviders();
			if(restlist!=null&&restlist.size()>0){
				Provider p;
				SQLiteFactory sqf = SQLiteFactory.getInstance();
				sqf.executeSQL("delete from "+Provider.TABLE_NAME);
				for(RESTProvider _provider:restlist){
					p = new Provider();
					p.description = _provider.getDescription();
					p.id = _provider.getId();
					p.logo = _provider.getLogo();
					p.name = _provider.getName();
					p.rank = _provider.getRank();
					p.reg_url = _provider.getRegUrl();
					p.web_url = _provider.getUrl();
					sqf.saveModel(p);
				}
			}
		} catch (DefaultException e) {
			e.printStackTrace();
		}
	}
	
}
