package com.zhelazhela.cloudblog.services.impl;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;


import com.zhelazhela.cloudblog.domain.ACK;
import com.zhelazhela.cloudblog.domain.Result;
import com.zhelazhela.cloudblog.services.Maintenance;
import com.zhelazhela.db.dao.ProvidersDAO;
import com.zhelazhela.db.model.Providers;
import com.zhelazhela.db.model.ProvidersExample;

public class MaintenanceImpl implements Maintenance {

	private ProvidersDAO providersDAO;
	
	public void setProvidersDAO(ProvidersDAO providersDAO) {
		this.providersDAO = providersDAO;
	}

	@Override
	public ACK testNetwork(Map<String, String> parameters) {
		String provider = parameters.get("provider");
		ACK ack = new ACK();
		if(provider!=null){
			ProvidersExample pe = new ProvidersExample();
			pe.createCriteria().andNameEqualTo(provider).andLevelEqualTo(Providers.LEVEL_OK);
			java.util.List<Providers> list = providersDAO.selectByExample(pe);
			if(list.size()>0){
				ack.setResultCode(Result.SUCCESS);
				ack.setResultDesc("Status:OK");
				return ack;
			}
		}
		ack.setResultCode(Result.FAIL);
		ack.setResultDesc("There's no this provider");
		return ack;
	}

	@Override
	public ACK getSerialID(Map<String, String> parameters) {
		String appkey = parameters.get("appkey");
		String sessionid = parameters.get("serialid");
		ACK ack = new ACK();
		String enc_session = "";
		if(appkey!=null&&appkey.equals(APP_KEY)){
			boolean isapp = appkey.length()>sessionid.length();
			int len = isapp?sessionid.length():appkey.length();
			for(int i=0;i<len;i++){
				enc_session = enc_session + sessionid.charAt(i)+appkey.charAt(i);
			}
			if(isapp){
				appkey = appkey.substring(len);
			}else{
				appkey = sessionid.substring(len);
			}
			len = appkey.length();
			int enc_len = enc_session.length();
			Random r = new Random(enc_len);
			int enc_at = 0;
			for(int i=0;i<len;i++){
				enc_at = r.nextInt(enc_len);
				enc_session = enc_session.substring(0, enc_at) + appkey.charAt(i) + enc_session.substring(enc_at);
			}
			ack.setResultCode(Result.SUCCESS);
			ack.setResultDesc(enc_session);
		}else{
			ack.setResultCode(Result.FAIL);
			ack.setResultDesc("Your APP have no permission!");
		}
		return ack;
	}

	@Override
	public ACK checkSerialID(Map<String, String> parameters) {
		String enc_serialid = parameters.get("enc_serialid");
		String serialid = parameters.get("serialid");
		ACK ack = new ACK();
		ack.setResultCode(Result.FAIL);
		ack.setResultDesc("Your APP have no permission!");
		if(enc_serialid!=null&&serialid!=null&&serialid.length()>0){
			String md5 = getMD5Str(serialid);
			char md5_array[] = md5.toCharArray();
			md5 = "";
			int len = md5_array.length;
			char tmp;
			for(int i=0;i<len;i++){
				if(i%3==0&&(i+2)<len){
					tmp = md5_array[i];
					md5_array[i] = md5_array[i+2];
					md5_array[i+2] = tmp;
				}
				if(i%2==0&&(i+1)<len){
					tmp = md5_array[i];
					md5_array[i] = md5_array[i+1];
					md5_array[i+1] = tmp;
				}
				md5 = md5+md5_array[i];
			}
			if(md5.equals(enc_serialid)){
				ack.setResultCode(Result.SUCCESS);
				ack.setResultDesc("Thank you!");
			}
		}
		return ack;
	}

	private String getMD5Str(String str) {  
        MessageDigest messageDigest = null;  
        try {  
            messageDigest = MessageDigest.getInstance("MD5");  
            messageDigest.reset();  
            messageDigest.update(str.getBytes("UTF-8"));  
        } catch (Exception e) {  
            System.out.println("NoSuchAlgorithmException caught!");  
        }
        byte[] byteArray = messageDigest.digest();  
        StringBuffer md5StrBuff = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
        return md5StrBuff.toString();  
    }
}
