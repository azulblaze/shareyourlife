package com.zhela.android.activity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.DefaultHttpClient;

import com.zhela.android.core.net.HttpParse;
import com.zhela.android.core.net.NetStatusException;
import com.zhela.android.core.remote.model.RESTInternalUser;
import com.zhela.android.core.remote.model.RESTTweet;

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
			RESTInternalUser user = hp.getResponse(HttpParse.METHOD_GET, "http://124.14.140.249:8080/cloudblog/api/users/cashguy/chenyan.json", null, null, null, RESTInternalUser.class);
			if(user!=null){
				Map<String, String> params = new HashMap<String,String>();
				params.put("pa", "yan925@gmail.com");
				params.put("text", java.net.URLEncoder.encode("中文test","utf-8"));
				String action = "http://124.14.140.249:8080/cloudblog/api/providers/1/tweets/content.json";
				RESTTweet tweet = hp.getResponse(HttpParse.METHOD_MULTIPARTPOST, action, params, new File("sdcard/test.JPG"), "attachmentFile", RESTTweet.class);
				if(tweet!=null){
					tv.setText(tweet.getContent());
				}
			}
		} catch (Exception e) {
			if(e instanceof NetStatusException){
				tv.setText(((NetStatusException)e).getResponse());
			}else{
				tv.setText(e.getMessage());
			}
		}
    }
}