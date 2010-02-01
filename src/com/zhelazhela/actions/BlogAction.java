package com.zhelazhela.actions;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.feed.synd.SyndImage;
import com.sun.syndication.feed.synd.SyndImageImpl;
import com.sun.syndication.io.SyndFeedOutput;
import com.zhelazhela.db.model.BlogComments;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.BlogQa;
import com.zhelazhela.domain.BlogDetailList;
import com.zhelazhela.services.BlogService;
import com.zhelazhela.system.config.SystemConfig;

@SuppressWarnings("serial")
public class BlogAction extends BaseAction {
	
	private int page;
	
	private int pagesize;
	
	private BlogService blogService;
		
	private long id;
		
	private String tag;
	
	private String category;
	
	private BlogQa blogQa;
	
	private BlogComments blogComment;
	
	private String validate_code;
	
	private SystemConfig systemConfig;
	
	private static final String MIME_TYPE = "application/xml; charset=UTF-8";   
    
    // rss_0.90, rss_0.91, rss_0.92, rss_0.93, rss_0.94, rss_1.0, rss_2.0, atom_0.3    
    private static final String RSS_TYPE = "rss_2.0"; 
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BlogQa getBlogQa() {
		return blogQa;
	}

	public void setBlogQa(BlogQa blogQa) {
		this.blogQa = blogQa;
	}

	public BlogComments getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(BlogComments blogComment) {
		this.blogComment = blogComment;
	}
	
	

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public String getValidate_code() {
		return validate_code;
	}

	public void setValidate_code(String validateCode) {
		validate_code = validateCode;
	}

	public String index() throws Exception{
		setValue("nav","list");
		setValue("categorys",blogService.loadCategorys());
		setValue("tags",blogService.loadTopTags(12));
		if(page<=0){
			page = 1;
		}
		setValue("result",blogService.loadList(page, pagesize, null, null, null, true, null));
		return SUCCESS;
	}
	
	public String list() throws Exception{
		setValue("nav","list");
		setValue("categorys",blogService.loadCategorys());
		setValue("tags",blogService.loadTopTags(12));
		/** url rewriter help us to make the code to utf-8
		if(tag!=null){
			tag = new String(tag.getBytes("iso-8859-1"),"utf-8");
		}
		if(category!=null){
			category = new String(category.getBytes("iso-8859-1"),"utf-8");
		}
		**/
		setValue("c_tag",tag);
		setValue("c_category",category);
		if(page<=0){
			page = 1;
		}
		if(tag!=null&&tag.trim().length()>0){
			setValue("result",blogService.loadList(page, pagesize, tag));
		}else{
			setValue("result",blogService.loadList(page, pagesize, category, null, null, true, null));
		}
		return SUCCESS;
	}
	
	public String detail() throws Exception{
		setValue("categorys",blogService.loadCategorys());
		setValue("tags",blogService.loadTopTags(12));
		BlogDetail bd = blogService.loadBlogDetail(id);
		setValue("nav","detail");
		if(bd.getPublished()){
			setValue("blog",bd);
			setValue("cust_title",bd.getTitle());
		}else{
			throw new Exception();
		}
		setValue("categorys",blogService.loadCategorys());
		setValue("tags",blogService.loadTopTags(12));
		return SUCCESS;
	}
	
	public String suggest() throws Exception{
		setValue("categorys",blogService.loadCategorys());
		setValue("tags",blogService.loadTopTags(12));
		setValue("nav","suggest");
		if(blogQa==null){
			return INPUT;
		}
		if(!blogQa.isValid()||validate_code==null||!validate_code.equals((String)getSession("blog_suggest"))){
			this.clearSession("blog_suggest");
			setValue("qa",blogQa);
			saveSession("msg","not");
			return INPUT;
		}
		blogService.Question(blogQa);
		saveSession("msg","yes");
		return SUCCESS;
	}
	
	public String comment() throws Exception{
		if(blogComment==null){
			return null;
		}
		JSONObject jb = new JSONObject();
		if(validate_code==null||!validate_code.equals((String)getSession("blog_comment"))){
			this.clearSession("blog_comment");
			jb.put("msg", "您必须输入正确的验证码才能提交！");
			jb.put("result", "fail");
			setValue("json", jb.toString());
			return "json";
		}
		blogComment.setIpAddr(getHttpServletRequest().getRemoteAddr());
		if(StringUtils.isBlank(blogComment.getUserName())){
			blogComment.setUserName("匿名网友");
		}
		if(blogComment!=null&&blogComment.isValid()){
			blogComment = blogService.comment(blogComment);
			jb.put("data", blogComment);
		}
		if(blogComment!=null){
			jb.put("result", "success");
			jb.put("msg", "评论成功");
		}else{
			jb.put("result", "fail");
			jb.put("msg", "评论失败");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	public String comment_list() throws Exception{
		java.util.List<BlogComments> bcs = blogService.loadComment(id);
		setValue("comment",bcs);
		setValue("size",bcs.size());
		return SUCCESS;
	}
	
	public String rss() throws Exception{
		SyndFeed feed = new SyndFeedImpl();
		feed.setAuthor("这啦折啦博客");
		feed.setTitle("这啦折啦博客");
		feed.setLink(systemConfig.getDomain());
		feed.setDescription("这啦折啦博客是这啦折啦与大家分享交流的地方.");
		SyndImage image = new SyndImageImpl();
		image.setTitle("这啦折啦博客");
		image.setLink(systemConfig.getDomain());
		image.setUrl(systemConfig.getDomain()+"/zhelazhela.png");
		feed.setImage(image);
		BlogDetailList dnl = blogService.loadList(1, 30, null, null, null, true, null);
		java.util.List<SyndEntry> entrys = new java.util.ArrayList<SyndEntry>();
		SyndEntry se = null;
		SyndContent description = null;
		for(BlogDetail dn:dnl.getList()){
			se = new SyndEntryImpl();   
			se.setTitle(dn.getTitle());   
			se.setLink(systemConfig.getDomain()+"/blog/detail/"+dn.getId()+".html");   
			se.setPublishedDate(dn.getUpdateTime());   
			description = new SyndContentImpl();   
			description.setType("text/html");   
			description.setValue(dn.getReview());   
			se.setDescription(description);   
			entrys.add(se);
		}
		if(dnl.getList().size()>0){
			feed.setPublishedDate(dnl.getList().get(0).getUpdateTime());
		}else{
			feed.setPublishedDate(new java.util.Date());
		}
		
		feed.setEntries(entrys);
		feed.setFeedType(RSS_TYPE);
		HttpServletResponse response = getHttpServletResponse();
		response.setContentType(MIME_TYPE);
		try{
			SyndFeedOutput output = new SyndFeedOutput();
			output.output(feed, response.getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
