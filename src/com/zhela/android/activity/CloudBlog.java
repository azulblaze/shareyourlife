package com.zhela.android.activity;


import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.HttpParse;
import com.zhela.android.core.util.DeviceInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class CloudBlog extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        System.out.println("=======start============");
        new DeviceInfo().getInfo();
        TelephonyManager tm = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        new DeviceInfo().getIME(tm);
        System.out.println("=======end============");
        DefaultHttpClient hc = new DefaultHttpClient();
		HttpParse hp = new HttpParse(hc);
		TextView tv = (TextView)this.findViewById(R.id.loadinfo);
    }
}