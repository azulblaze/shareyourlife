package com.zhela.android.core.util;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceInfo {
	public void getInfo(){
		try{
			int version = 3;
		    Class<android.os.Build.VERSION> build_version_class = android.os.Build.VERSION.class;
		    //get android version                
		    java.lang.reflect.Field field = build_version_class.getField("SDK_INT");
		    version = (Integer) field.get(new android.os.Build.VERSION());
		    Class<android.os.Build> build_class = android.os.Build.class;
		    //get band
		    java.lang.reflect.Field manu_field = build_class.getField("MANUFACTURER");
		    String manufacturer = (String) manu_field.get(new android.os.Build());
		    //get model
		    java.lang.reflect.Field field2 = build_class.getField("MODEL");
		    String model = (String) field2.get(new android.os.Build());
		    //get device
		    java.lang.reflect.Field device_field = build_class.getField("DEVICE");
		    String device = (String) device_field.get(new android.os.Build());
		    
		    
		    System.out.println("band:" + manufacturer + "model:" + model + "sdk version:" + version + "DEVICE:" + device);
		}catch(Exception e){
			System.out.println("==============");
			e.printStackTrace();
		}
	}
	
	public void getIME(TelephonyManager tm){
		try{
            StringBuilder sb = new StringBuilder();
            sb.append("\nDeviceId(IMEI) = " + tm.getDeviceId());
            sb.append("\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion());
            sb.append("\nLine1Number = " + tm.getLine1Number());
            sb.append("\nNetworkCountryIso = " + tm.getNetworkCountryIso());
            sb.append("\nNetworkOperator = " + tm.getNetworkOperator());
            sb.append("\nNetworkOperatorName = " + tm.getNetworkOperatorName());
            sb.append("\nNetworkType = " + tm.getNetworkType());
            sb.append("\nPhoneType = " + tm.getPhoneType());
            sb.append("\nSimCountryIso = " + tm.getSimCountryIso());
            sb.append("\nSimOperator = " + tm.getSimOperator());
            sb.append("\nSimOperatorName = " + tm.getSimOperatorName());
            sb.append("\nSimSerialNumber = " + tm.getSimSerialNumber());
            sb.append("\nSimState = " + tm.getSimState());
            sb.append("\nSubscriberId(IMSI) = " + tm.getSubscriberId());
            sb.append("\nVoiceMailNumber = " + tm.getVoiceMailNumber());
            System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
