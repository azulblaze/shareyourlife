package com.zhela.android.activity;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.FormFile;
import com.zhela.android.core.net.HttpParse;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CloudBlog extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DefaultHttpClient hc = new DefaultHttpClient();
		HttpParse hp = new HttpParse(hc);
		TextView tv = (TextView)this.findViewById(R.id.content);
		try {
			String str = hp.test();
			String action = "http://mylaptop:8080/cloudblog/api/users/header.json";
			Map<String, String> params = new HashMap<String,String>();
			//params.put("pa", "yan925@gmail.com");
			//params.put("text", "Hello,From my android App");
			FormFile files[] = new FormFile[1];
			files[0] = new FormFile("/mnt/sdcard/test.JPG","attachmentFile");
			str = hp.put(action, params, files[0]);
			tv.setText(str);
		} catch (Exception e) {
			tv.setText(e.getMessage());
			e.printStackTrace();
		}
    }
}