package com.zhela.android.core.util;

import android.telephony.TelephonyManager;

public class DeviceInfo {
	
	public class INFO{
		public String version = "android-unknown";
		public String band = "unknown";
		public String model = "-unknown";
		public String IMEI = "000000000000000";
	}
	
	public INFO getInfo(TelephonyManager tm){
		INFO _info = new INFO();
		Class<android.os.Build.VERSION> build_version_class;
		try{
			build_version_class = android.os.Build.VERSION.class;
		    //get android version                
		    java.lang.reflect.Field field = build_version_class.getField("SDK_INT");
		    int _version = (Integer)field.get(new android.os.Build.VERSION());
		    if(_version>0){
		    	_info.version = "android-"+_version;
		    }
		}catch(Exception e){
		}
		Class<android.os.Build> build_class = null;
		try{
			build_class = android.os.Build.class;
		    //get band
		    java.lang.reflect.Field manu_field = build_class.getField("MANUFACTURER");
		    String manufacturer = (String) manu_field.get(new android.os.Build());
		    if(manufacturer!=null&&manufacturer.trim().length()>0){
		    	_info.band = manufacturer.trim();
		    }
		}catch(Exception e){
		}
		try{
		    //get model
		    java.lang.reflect.Field field2 = build_class.getField("MODEL");
		    String _model = (String) field2.get(new android.os.Build());
		    if(_model!=null&&_model.trim().length()>0){
		    	_info.model = "-"+_model;
		    }
		}catch(Exception e){
		}
		try{
			String _imei = tm.getDeviceId();
			if(_imei!=null&&_imei.trim().length()>0){
				_info.IMEI = _imei.trim();
			}
		}catch(Exception e){
		}
		return _info;
	}
}
