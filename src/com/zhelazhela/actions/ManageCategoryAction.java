package com.zhelazhela.actions;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.domain.CategoryList;
import com.zhelazhela.services.UtilService;

@SuppressWarnings("serial")
public class ManageCategoryAction extends BaseAction{
	
	private UtilService utilService;
	
	private int page;
	
	private int pagesize;
	/** category id */
	private long c_id;
	
	private long f_id;
	
	private MerchandiseCategory mc;
	
	public String addCategory() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		MerchandiseCategory category = utilService.addCategory(mc.getFather(), true, mc.getName(), mc.getDescription());
		if(category!=null){
			jb.put("result", "success");
			jb.put("data", category);
			jb.put("msg", "添加成功");
			setValue("json",jb.toString());
			return "json";
		}
		jb.put("result", "fail");
		jb.put("msg", "添加失败，注意名字不能重复");
		setValue("json",jb.toString());
		return "json";
	}
	
	public String delCategory() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		try{
			utilService.delCategory(c_id);
			jb.put("result", "success");
			jb.put("msg", "删除成功");
			setValue("json", jb.toString());
			return "json";
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}
	
	public String viewCategory() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		setValue("result",utilService.loadCategory(c_id));
		return SUCCESS;
	}
	
	public String editCategory() throws Exception{
		JSONObject jb = new JSONObject();
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			jb.put("result", "login");
			setValue("json",jb.toString());
			return "json";
		}
		jb.put("result", "fail");
		setValue("json",jb.toString());
		return "json";
	}
	
	public String listCategory() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		if(f_id>0){
			java.util.List<MerchandiseCategory> list = utilService.loadCategorys(f_id);
			CategoryList cl = new CategoryList();
			cl.setPage(1);
			cl.setList(list);
			cl.setPagesize(list.size());
			cl.setSize(list.size());
			this.setValue("result", cl);
		}else{
			this.setValue("result", utilService.loadAllCategorys(page,pagesize));
		}
		return SUCCESS;
	}
	
	public String childCategory() throws Exception{
		JSONObject jb = new JSONObject();
		try{
			java.util.List<MerchandiseCategory> list = utilService.loadCategorys(f_id);
			JSONArray ja = new JSONArray();
			ja.addAll(list);
			jb.put("result", "success");
			jb.put("msg", "取得子类别");
			jb.put("data", ja);
			setValue("json", jb.toString());
			return "json";
		}catch(Exception e){
			jb.put("msg", e.getMessage());
		}
		jb.put("result", "fail");
		setValue("json", jb.toString());
		return "json";
	}

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

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long cId) {
		c_id = cId;
	}

	public long getF_id() {
		return f_id;
	}

	public void setF_id(long fId) {
		f_id = fId;
	}

	public MerchandiseCategory getMc() {
		return mc;
	}

	public void setMc(MerchandiseCategory mc) {
		this.mc = mc;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}
	
	
	
}
