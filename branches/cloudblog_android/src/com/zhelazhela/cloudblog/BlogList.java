package com.zhelazhela.cloudblog;

import com.zhelazhela.cloudblog.domain.Post;
import com.zhelazhela.cloudblog.domain.User;
import com.zhelazhela.cloudblog.ui.BlogDetailAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class BlogList extends Activity {
	public static BlogList activity;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloglist);
        ListView sv = (ListView)findViewById(R.id.blogs_container_list);
        java.util.List<Post> posts = new java.util.ArrayList<Post>();
        for(int i=0;i<10;i++){
        	Post post = new Post();
        	User user = new User();
        	user.setProfile_image_url("http://tp3.sinaimg.cn/1490372962/50/1282670302");
        	post.setUser(user);
        	post.setCreated_at(new java.util.Date()+"一天以前 ");
        	post.setSource("<a href='qq.com'>腾讯</a>");
        	post.setText("<a href='google.com'>google.com</a>Tis i第十六发山东龙口附件乐山大佛斯蒂芬就阿里山等级分 临时单据反动势力发上篮得分技术大力开发 临时单据费力的事发乐山大佛降低税率辅导书 s ftesfsldkfjsdlkf"+i);
        	posts.add(post);
        }
       BlogDetailAdapter bda = new BlogDetailAdapter(this,posts,sv);
       sv.setAdapter(bda);
    }
    
    
    
}