package com.zhelazhela.services.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.ProgramInfoDAO;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.domain.ProgramInfoList;
import com.zhelazhela.services.ProgramInfoService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.util.CommonMethod;

public class ProgramInfoServiceImpl implements ProgramInfoService {

	private ProgramInfoDAO programInfoDAO;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	protected SystemConfig systemConfig;
	
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}
	
	@Override
	public ProgramInfo addProgramInfo(ProgramInfo programInfo,String root_path,String filetype,java.io.File logo) throws Exception {
		if(logo!=null&&logo.length()>systemConfig.getUpload_pic_maxlength()){
			throw new Exception("上次文件大小超过"+systemConfig.getUpload_pic_maxlength()/(1024*1024)+"MB限制");
		}
		TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			if(logo!=null){
				CommonMethod cm = CommonMethod.newInstance();
				programInfo.setLog(cm.saveLogo(logo, root_path, systemConfig.getUpload_logo(), filetype));
			}
			long result = programInfoDAO.insertSelectiveReturnId(programInfo);
			if(result>0){
				this.m_db_tx_manager.commit(status);
				return programInfoDAO.selectByPrimaryKey(result);
			}else{
				this.m_db_tx_manager.rollback(status);
				throw new java.lang.Exception("保存商家信息失败");
			}
		}catch(Exception e){
			this.m_db_tx_manager.rollback(status);
			throw new java.lang.Exception(e.getMessage());
		}
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

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	

	
}
