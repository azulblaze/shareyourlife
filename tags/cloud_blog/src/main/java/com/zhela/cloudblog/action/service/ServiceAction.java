package com.zhela.cloudblog.action.service;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zhela.cloudblog.action.BaseAction;
import com.zhela.cloudblog.action.model.JSONResponse;
import com.zhela.cloudblog.dao.ourservice.MakeBetterDAO;
import com.zhela.cloudblog.model.ourservice.MakeBetter;
import com.zhela.cloudblog.model.ourservice.MakeBetterExample;
import com.zhela.cloudblog.model.users.Users;
import com.zhela.cloudblog.util.CommonMethod;

@SuppressWarnings("serial")
public class ServiceAction extends BaseAction {

	private MakeBetter better;
	private File file;
	private String fileContentType;
	private MakeBetterDAO makeBetterDAO;
	private long id;
	public String allservice() throws Exception{
		return SUCCESS;
	}
	
	public String myservice() throws Exception{
		return SUCCESS;
	}
	
	public String makeBetter() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null){
			return LOGIN;
		}
		if(better==null){
			return INPUT;
		}
		String extType = "";
		if(file!=null&&fileContentType!=null){
			extType = CommonMethod.getInstance().isAllowedPicture(fileContentType);
			if(extType==null){
				setValue("error","附件只能为图片或者ZIP/RAR的压缩文件");
				return INPUT;
			}
		}
		if(StringUtils.isBlank(better.getTittle())){
			setValue("error","必须输入标题");
			return INPUT;
		}
		if(StringUtils.isBlank(better.getServiceName())){
			setValue("error","必须选择一个服务名称");
			return INPUT;
		}
		if(StringUtils.isBlank(better.getType())){
			setValue("error","必须选择一种类型");
			return INPUT;
		}
		if(StringUtils.isBlank(better.getContent())&&StringUtils.isBlank(fileContentType)){
			setValue("error","请填写具体的内容，或者通过附件上传");
			return INPUT;
		}
		if(StringUtils.isNotBlank(extType)){
			String path = CommonMethod.getInstance().saveFile(file, getRootPath(), "/upload/makebetter", extType);
			better.setAttachment(path);
		}
		better.setAccount(_user.getAccount());
		if(StringUtils.isBlank(better.geteMail())){
			better.seteMail(_user.geteMail());
		}
		better.setUpdateTime(new java.util.Date());
		makeBetterDAO.insert(better);
		setValue("error","提交成功，感谢你对我们的支持");
		return INPUT;
	}

	public String BetterInfo() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null||!_user.getAccount().equals("admin")){
			return LOGIN;
		}
		List<MakeBetter> list = makeBetterDAO.selectByExampleWithBLOBs(new MakeBetterExample());
		setValue("list",list);
		return SUCCESS;
	}
	
	public String delBetterInfo() throws Exception{
		Users _user = (Users)getSession(session_user);
		if(_user==null||!_user.getAccount().equals("admin")){
			setValue(JSON,new JSONResponse(JSONResponse.LOGIN,"").toJSON());
			return JSON;
		}
		try{
			MakeBetter tmp = makeBetterDAO.selectByPrimaryKey(id);
			if(tmp!=null){
				if(tmp.getAttachment()!=null){
					try{
						CommonMethod.getInstance().deleteFile(getRootPath()+tmp.getAttachment());
					}catch(Exception e){
						
					}
				}
				makeBetterDAO.deleteByPrimaryKey(id);
				setValue(JSON,new JSONResponse(JSONResponse.SUCCESS,"").toJSON());
			}else{
				setValue(JSON,new JSONResponse(JSONResponse.FAIL,"不存在").toJSON());
			}
		}catch(Exception e){
			setValue(JSON,new JSONResponse(JSONResponse.FAIL,e.getMessage()).toJSON());
		}
		return JSON;
	}
	
	public MakeBetter getBetter() {
		return better;
	}

	public void setBetter(MakeBetter better) {
		this.better = better;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public void setMakeBetterDAO(MakeBetterDAO makeBetterDAO) {
		this.makeBetterDAO = makeBetterDAO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
