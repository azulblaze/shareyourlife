package com.zhela.android.activity;

import com.zhela.android.R;
import com.zhela.android.component.ConfigureLoad;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.model.User;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.util.CommonResource;
import com.zhela.android.core.util.DeviceInfo;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class CloudBlog extends DefaultActivity {
	private TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        tv = (TextView)this.findViewById(R.id.loadinfo);
        init.start();
//      //for test
//        try{
//        	ServiceImpl sss = new ServiceImpl();
//        	new DeviceInfo().getInfo(tm);
//        	sss.authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI);
//        	sss.login("cashguy", "chenyan");
//        	//String id = sss.postTweet(1l, "yan925@gmail.com", "来自android4444444444444", null, null, null, new java.io.File("sdcard/test.JPG")).getId();
//        	RESTComment comment = sss.postCommentByTweet(1l, "yan925@gmail.com", "3716914277", "尝试恢复评论lkfsfdfdsf", "4593256463");
//        	if(comment!=null){
//        		System.out.println("===================");
//        	}
//        }catch(Exception e){
//        	e.printStackTrace();
//        }
//        //init
    }
    
    
    
    
    private Handler loadHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				tv.setText((String)msg.obj);
				break;
			case -1:
				tv.setText("验证失败");
				Object o = msg.obj;
    			AlertDialog.Builder alert = new AlertDialog.Builder(CloudBlog.this)
				.setTitle("错误").setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						setResult(RESULT_OK);
						finish();
					}
				});
    			if(o instanceof DefaultException){
    				o = (DefaultException)o;
    				alert.setMessage(((DefaultException) o).getMessage());//设置显示的内容
        			alert.show();
    			}else{
    				alert.setMessage(((Exception) o).getMessage());//设置显示的内容
        			alert.show();
    			}
			}
		}
	};
    Thread init = new Thread(new Runnable(){
    	public void run(){
    		try{
    			loadHandler.sendMessage(CommonResource.getMessage(0,"配置文件读取 ···"));
    			ConfigureLoad cl = new ConfigureLoad(CloudBlog.this);
    			cl.loadServerInfo();
    			loadHandler.sendMessage(CommonResource.getMessage(0,"服务加载中 ···"));
                Service service = new ServiceImpl();
                cl.loadDeviceInfo();
    			loadHandler.sendMessage(CommonResource.getMessage(0,"验证客户端中 ···"));
    			if(service.authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
        			loadHandler.sendMessage(CommonResource.getMessage(0,"客户端验证成功"));
    			}else{
        			loadHandler.sendMessage(CommonResource.getMessage(-1,"客户端验证失败"));
    			}
    			//init database
    			cl.initDB();
    			//load users account
    			loadHandler.sendMessage(CommonResource.getMessage(0,"读取帐号信息···"));
    			SQLService sqls = new SQLService();
    			UtilInfo.usersCount = sqls.getUserCount();
    			Intent login = new Intent(CloudBlog.this,Login.class); 
    			User users = sqls.getDefaultUsers();
				if(users!=null){
					UtilInfo.loginusers = users;
					UtilInfo.loginusers.want_login = true;
				}
    			CloudBlog.this.startActivity(login); 
    			CloudBlog.this.finish();
    		}catch(Exception e){
    			loadHandler.sendMessage(CommonResource.getMessage(-1,e));
    		}
    	}
    });
}