package com.zhela.android.activity;



import com.zhela.android.R;
import com.zhela.android.core.db.SQLService;
import com.zhela.android.core.db.SQLiteFactory;
import com.zhela.android.core.db.SQLiteSupport;
import com.zhela.android.core.db.Users;
import com.zhela.android.core.remote.business.Service;
import com.zhela.android.core.remote.business.ServiceImpl;
import com.zhela.android.core.remote.model.RESTComment;
import com.zhela.android.core.util.DeviceInfo;
import com.zhela.android.core.util.UtilInfo;
import com.zhela.android.exception.DefaultException;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class CloudBlog extends DefaultActivity {
	private TextView tv;
	private TelephonyManager tm;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        tv = (TextView)this.findViewById(R.id.loadinfo);
        tm = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        init.start();
      //for test
        try{
        	ServiceImpl sss = new ServiceImpl();
        	new DeviceInfo().getInfo(tm);
        	sss.authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI);
        	sss.login("cashguy", "chenyan");
        	//String id = sss.postTweet(1l, "yan925@gmail.com", "来自android4444444444444", null, null, null, new java.io.File("sdcard/test.JPG")).getId();
        	RESTComment comment = sss.postCommentByTweet(1l, "yan925@gmail.com", "3716914277", "尝试恢复评论lkfsfdfdsf", "4593256463");
        	if(comment!=null){
        		System.out.println("===================");
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
        //init
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
    		Message message = new Message();
    		try{
    			message.what = 0;
    			message.obj = "配置文件读取 ···";
    			loadHandler.sendMessage(message);
    			PackageManager manager = CloudBlog.this.getPackageManager();
    			ApplicationInfo info = manager.getApplicationInfo(CloudBlog.this.getPackageName(), 128);
    			if (info != null){
    				 ServiceImpl.BASE_URL = info.metaData.getString("BOLE_SERVER");
    			}
    			message = new Message();
    			message.what = 0;
    			message.obj = "服务加载中 ···";
    			loadHandler.sendMessage(message);
                Service service = new ServiceImpl();
                new DeviceInfo().getInfo(tm);
                message = new Message();
                message.what = 0;
    			message.obj = "验证客户端中 ···";
    			loadHandler.sendMessage(message);
    			if(service.authClient(DeviceInfo.systemInfo.band+DeviceInfo.systemInfo.model, DeviceInfo.systemInfo.version, DeviceInfo.systemInfo.IMEI)){
    				message = new Message();
    				message.what = 0;
        			message.obj = "客户端验证成功";
        			loadHandler.sendMessage(message);
    			}else{
    				message = new Message();
    				message.what = -1;
        			message.obj = "客户端验证失败";
        			loadHandler.sendMessage(message);
    			}
    			//init database
    			SQLiteSupport sqlHelper = new SQLiteSupport(CloudBlog.this,"bole",null,UtilInfo.bole_version);  
    			SQLiteFactory.instance = sqlHelper;
    			//load users account
    			message = new Message();
				message.what = 0;
    			message.obj = "读取帐号信息···";
    			loadHandler.sendMessage(message);
    			SQLService sqls = new SQLService();
    			UtilInfo.usersCount = sqls.getUserCount();
    			Intent login = new Intent(CloudBlog.this,Login.class); 
    			Users users = sqls.getDefaultUsers();
				if(users!=null){
					users.want_login = true;
					login.getExtras().putSerializable("loginUser", users);
				}
    			CloudBlog.this.startActivity(login); 
    			CloudBlog.this.finish();
    		}catch(Exception e){
    			message = new Message();
    			message.what = -1;
    			message.obj = e;
    			loadHandler.sendMessage(message);
    		}
    	}
    });
}