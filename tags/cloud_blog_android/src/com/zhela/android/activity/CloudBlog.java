package com.zhela.android.activity;


import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.util.DeviceInfo;
import com.zhela.android.exception.DefaultException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class CloudBlog extends Activity {
	private TextView tv;
	private TelephonyManager tm;
	private CloudBlog current = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView)this.findViewById(R.id.loadinfo);
        tm = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        new LoadThread().start();
    }
    class LoadThread extends Thread{
    	public void run(){
    		try{
    			tv.setText("服务加载中 ···");
                Service service = new ServiceImpl();
                DeviceInfo.INFO _info = new DeviceInfo().getInfo(tm);
                tv.setText("验证客户端中 ···");
                try {
        			if(service.authClient(_info.band+_info.model, _info.version, _info.IMEI)){
        				tv.setText("客户端验证成功!");
        			}
        		} catch (DefaultException e) {
        			throw e;
        			
        		}
    		}catch(Exception e){
    			AlertDialog.Builder alert = new AlertDialog.Builder(current);
    			alert.setTitle("错误");//设置标题
    			alert.setPositiveButton("", new DialogInterface.OnClickListener(){
    						public void onClick(DialogInterface arg0, int arg1){
    							//finish();
    						}
    					});
    			if(e instanceof DefaultException){
    				e = (DefaultException)e;
    				alert.setMessage(e.getMessage());//设置显示的内容
        			alert.create().show();
    			}else{
    				alert.setMessage(e.getMessage());//设置显示的内容
        			alert.create().show();
    			}
    		}
    		
    	}
    }
    public void finish(){
    	this.finish();
    }
}