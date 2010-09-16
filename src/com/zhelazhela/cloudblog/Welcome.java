package com.zhelazhela.cloudblog;

import java.util.ArrayList;
import java.util.HashMap;

import com.zhelazhela.cloudblog.ui.BlogDetailAdapter;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;

public class Welcome extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloglist);
        ListView sv = (ListView)findViewById(R.id.blogs_container_list);
        ArrayList<HashMap<String, String>> mylist = new java.util.ArrayList<java.util.HashMap<String, String>>();
        for(int i=0;i<10;i++){
        	java.util.HashMap<String, String> map = new java.util.HashMap<String, String>();
        	map.put("blog_text", "<a href='google.com'>google.com</a>Tis i第十六发山东龙口附件乐山大佛斯蒂芬就阿里山等级分 临时单据反动势力发上篮得分技术大力开发 临时单据费力的事发乐山大佛降低税率辅导书 s ftesfsldkfjsdlkf"+i);
        	map.put("blog_from", "This is from"+i);
        	mylist.add(map);
        }
        BlogDetailAdapter bda = new BlogDetailAdapter(this,mylist);
        sv.setAdapter(bda);
    }
    
    
    
}