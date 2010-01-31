package com.zhelazhela.actions;

import java.io.File;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.BlogDetail;
import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.services.BlogService;
import com.zhelazhela.util.CommonMethod;

@SuppressWarnings("serial")
public class ManageBlogAction extends BaseAction {
	
	private int page;
	
	private int pagesize;
	
	private BlogService blogService;
	
	private int type;
	
	private long id;
	
	private BlogDetail blogDetail;
	
	private String tag;
	
	private File pic;
	
	private String picContentType;
		
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
	public BlogService getBlogService() {
		return blogService;
	}
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BlogDetail getBlogDetail() {
		return blogDetail;
	}
	public void setBlogDetail(BlogDetail blogDetail) {
		this.blogDetail = blogDetail;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String list() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		setValue("type",type);
		if(type==0){
			//未发布的
			setValue("result",blogService.loadList(page, pagesize, null, null, null, false, null));
		}
		if(type==1){
			//已发布的
			setValue("result",blogService.loadList(page, pagesize, null, null, null, true, null));
		}
		return SUCCESS;
	}
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	public String publish() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		try{
			boolean result  = blogService.publishBlog(id,getRootPath());
			if(result){
				jb.put("result", "success");
				jb.put("msg", "发布成功");
				setValue("json", jb.toString());
				return "json";
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}
	
	public String delblog() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		try{
			boolean result  = blogService.delBlog(id);
			if(result){
				jb.put("result", "success");
				jb.put("msg", "删除成功");
				setValue("json", jb.toString());
				return "json";
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}
	
	public String detail() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		setValue("blog",blogService.loadBlogDetail(id));
		return SUCCESS;
	}
	
	public String input() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(blogDetail==null){
			blogDetail = new BlogDetail();
		}
		if(!blogDetail.isValid()){
			setValue("blog",blogDetail);
			setValue("tag",tag);
			return INPUT;
		}
		blogDetail.setId(null);
		blogDetail = blogService.saveBlog(blogDetail, tag);
		this.id = blogDetail.getId();
		return "detail";
	}
	
	public String edit() throws Exception {
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(id>0){//go to edit input page
			BlogDetail bd = blogService.loadBlogDetail(id);
			setValue("blog",bd);
			setValue("tag",bd.getTagStr());
			return INPUT;
		}else{
			if(blogDetail!=null&&blogDetail.getId()>0){
				if(blogDetail.isValid()){
					setValue("blog",blogService.updateBlogDetail(blogDetail, tag));
					this.id = blogDetail.getId();
					return "detail";
				}else{
					setValue("blog",blogDetail);
					setValue("tag",tag);
					setValue("msg","信息输入不完整");
					return INPUT;
				}
			}
			throw new Exception("wrong input");
		}
		
	}
	
	public String delQa() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		try{
			boolean result  = blogService.delQuestion(id);
			if(result){
				jb.put("result", "success");
				jb.put("msg", "删除成功");
				setValue("json", jb.toString());
				return "json";
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}
	
	public String listQa() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		setValue("result",blogService.loadBlogQaList(page, pagesize));
		return SUCCESS;
	}
	
	public String addBlogPic() throws Exception{
		ManageUser mu = (ManageUser)getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		try{
			String ext_type = CommonMethod.getInstance().isAllowedPicture(picContentType);
			if(picContentType!=null){
				if(ext_type==null){
					jb.put("result", "fail");
					jb.put("msg", "图片不支持您上传的格式");
					setValue("json",jb.toString());
					return "json";
				}
			}
			Attachments am = new Attachments();
			am.setRelTable("blog_detail");
			am.setRelTableId(0l);
			Attachments tmp = blogService.uploadPic(am, getRootPath(), ext_type, pic);
			if(tmp!=null){
				jb.put("result", "success");
				jb.put("pic", tmp);
				jb.put("msg", "上传图片成功");
				setValue("json",jb.toString());
				return "json";
			}
		}catch(Exception e){
			jb.put("msg", "提交失败:"+e.getMessage());
			return null;
		}
		jb.put("result", "fail");
		setValue("json",jb.toString());
		return "json";
	}
	
	public String listBlogPic() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		setValue("result",blogService.loadBlogPic(page, pagesize));
		return SUCCESS;
	}
	
	public String delBlogPic() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		try{
			boolean result  = blogService.delPic(id, getRootPath());
			if(result){
				jb.put("result", "success");
				jb.put("msg", "删除成功");
				setValue("json", jb.toString());
				return "json";
			}
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}
	
}
