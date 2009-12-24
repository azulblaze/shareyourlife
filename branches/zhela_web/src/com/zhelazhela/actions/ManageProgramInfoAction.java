package com.zhelazhela.actions;

import net.sf.json.JSONObject;

import com.zhelazhela.db.model.ManageUser;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.services.ProgramInfoService;

@SuppressWarnings("serial")
public class ManageProgramInfoAction extends BaseAction{
	
	private ProgramInfoService programInfoService;
	
	private ProgramInfo pi;
	
	private long pi_id;
	
	private int page;
	
	private int pagesize;
	
	private String keyword;
	
	
	public String addProgram() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			this.setValue("json", jb.toString());
			return "json";
		}
		if(pi!=null&&pi.validate()){
			ProgramInfo tmp = programInfoService.addProgramInfo(pi);
			if(tmp!=null){
				jb.put("result", "success");
				jb.put("pi", tmp.to_json());
				setValue("json",jb.toString());
				return "json";
			}
		}
		jb.put("result", "fail");
		setValue("json",jb.toString());
		return "json";
	}
	
	public String delProgram() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		JSONObject jb = new JSONObject();
		if(mu==null){
			jb.put("result", "login");
			setValue("json", jb.toString());
			return "json";
		}
		if(programInfoService.delProgramInfo(pi_id)){
			jb.put("result", "success");
		}else{
			jb.put("result", "fail");
		}
		setValue("json", jb.toString());
		return "json";
	}
	
	public String viewProgram() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		setValue("result",programInfoService.viewProgramInfo(pi_id));
		return SUCCESS;
	}
	
	public String editProgram() throws Exception{
		JSONObject jb = new JSONObject();
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			jb.put("result", "login");
			setValue("json",jb.toString());
			return "json";
		}
		if(pi!=null&&pi.validate()){
			ProgramInfo tmp = programInfoService.editProgramInfo(pi.getId(), pi.getName(), pi.getShortName(), pi.getWebsite(), pi.getEmail(), pi.getLog(), pi.getDescription());
			if(tmp!=null){
				jb.put("result", "success");
				jb.put("pi", tmp.to_json());
				setValue("json",jb.toString());
				return "json";
			}
		}
		jb.put("result", "fail");
		setValue("json",jb.toString());
		return "json";
	}
	
	public String listProgram() throws Exception{
		ManageUser mu = (ManageUser)this.getSession("manager");
		if(mu==null){
			return LOGIN;
		}
		if(page<=0){
			page = 1;
		}
		this.setValue("result", programInfoService.loadProgramInfo(page, pagesize, keyword));
		return SUCCESS;
	}

	public void setProgramInfoService(ProgramInfoService programInfoService) {
		this.programInfoService = programInfoService;
	}

	public ProgramInfo getPi() {
		return pi;
	}

	public void setPi(ProgramInfo pi) {
		this.pi = pi;
	}

	public long getPi_id() {
		return pi_id;
	}

	public void setPi_id(long piId) {
		pi_id = piId;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
