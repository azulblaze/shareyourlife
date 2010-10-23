package com.zhela.cloudblog.service.auth.impl;

import java.security.MessageDigest;
import java.util.Random;

import com.zhela.cloudblog.service.auth.ClientAuthService;

public class ClientAuthServiceImpl implements ClientAuthService{
	
	public String getSerialID(String appkey,String sessionid) {
		String enc_session = "";
		try{
			if(appkey!=null){
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
				Random r = new Random();
				int enc_at = 0;
				for(int i=0;i<len;i++){
					enc_at = r.nextInt(enc_len);
					enc_session = enc_session.substring(0, enc_at) + appkey.charAt(i) + enc_session.substring(enc_at);
				}
				return enc_session;
			}
		}catch(Exception e){
			
		}
		return null;
	}

	public boolean checkSerialID(String enc_serialid, String serialid) {
		if(enc_serialid!=null&&serialid!=null&&serialid.length()>0){
			try{
				
				if(getEncStr(serialid).equals(enc_serialid)){
					return true;
				}
			}catch(Exception e){
				
			}
		}
		return false;
	}

	private String getEncStr(String serialid){
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
		return md5;
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
