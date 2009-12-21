package com.zhelazhela.services.impl;

import java.util.List;

import com.zhelazhela.db.dao.ProgramInfoDAO;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.domain.ProgramInfoList;
import com.zhelazhela.services.ProgramInfoService;

public class ProgramInfoServiceImpl implements ProgramInfoService {

	private ProgramInfoDAO programInfoDAO;
	
	@Override
	public ProgramInfo addProgramInfo(ProgramInfo programInfo) throws Exception {
		long result = programInfoDAO.insertSelectiveReturnId(programInfo);
		if(result>0){
			return programInfoDAO.selectByPrimaryKey(result);
		}
		return null;
	}

	@Override
	public boolean delProgramInfo(long id) throws Exception {
		long row = programInfoDAO.deleteByPrimaryKey(id);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public ProgramInfo editProgramInfo(long id,String name, String shortname,
			String website, String email, String log, String description)
			throws Exception {
		ProgramInfo pi = programInfoDAO.selectByPrimaryKey(id);
		if(pi==null){
			return null;
		}
		boolean update = false;
		ProgramInfo tmp = new ProgramInfo();
		if(name!=null&&!name.equals(pi.getName())){
			tmp.setName(name);
			pi.setName(name);
			update = true;
		}
		if(shortname!=null&&!shortname.equals(pi.getShortName())){
			tmp.setShortName(shortname);
			pi.setShortName(shortname);
			update = true;
		}
		if(website!=null&&!website.equals(pi.getWebsite())){
			tmp.setWebsite(website);
			pi.setWebsite(website);
			update = true;
		}
		if(email!=null&&!email.equals(pi.getEmail())){
			tmp.setEmail(email);
			pi.setEmail(email);
			update = true;
		}
		if(log!=null&&!log.equals(pi.getLog())){
			tmp.setLog(log);
			pi.setLog(log);
			update = true;
		}
		if(description!=null&&!description.equals(pi.getDescription())){
			tmp.setDescription(description);
			pi.setDescription(description);
			update = true;
		}
		if(update){
			programInfoDAO.updateByPrimaryKeySelective(tmp);
		}
		return pi;
	}

	@Override
	public ProgramInfoList loadProgramInfo(int page, int pagesize , String keywords)
			throws Exception {
		java.util.List<ProgramInfo> list = null;
		if(pagesize>0){
			list = programInfoDAO.loadList((page-1)*pagesize, page*pagesize, keywords);
		}else{
			list = programInfoDAO.loadList(-1, -1, keywords);
		}
		ProgramInfoList pil = new ProgramInfoList();
		pil.setList(list);
		pil.setPagesize(pagesize);
		pil.setPage(page);
		pil.setSize(list.size());
		return pil;
	}
	
	@Override
	public ProgramInfo viewProgramInfo(long id) throws Exception {
		return programInfoDAO.selectByPrimaryKey(id);
	}
	

	public void setProgramInfoDAO(ProgramInfoDAO programInfoDAO) {
		this.programInfoDAO = programInfoDAO;
	}

	

	
}
