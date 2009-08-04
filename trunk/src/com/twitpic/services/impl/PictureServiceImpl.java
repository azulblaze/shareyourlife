package com.twitpic.services.impl;

import java.io.File;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.twitpic.db.dao.PicturesDAO;
import com.twitpic.db.dao.PicturesParameterDAO;
import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesParameter;
import com.twitpic.domain.PictureInfo;
import com.twitpic.domain.Account;
import com.twitpic.services.PictureService;
import com.twitpic.system.config.SystemConfig;
import com.twitpic.util.CommonMethod;
import com.twitpic.util.ConsVar;

/**
 * <code>PictureServiceImpl.java</code>
 * @version 1.0, 2009-8-3
 */
public class PictureServiceImpl implements PictureService {
	
	private SystemConfig systemConfig;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	private PicturesDAO picturesDAO;
	
	private PicturesParameterDAO picturesParameterDAO;
	
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}
	
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}
	
	public void setPicturesDAO(PicturesDAO picturesDAO) {
		this.picturesDAO = picturesDAO;
	}

	public void setPicturesParameterDAO(PicturesParameterDAO picturesParameterDAO) {
		this.picturesParameterDAO = picturesParameterDAO;
	}
	
	@Override
	public List<PictureInfo> load_picturesinfo_by_account(String account)
			throws Exception {
		return null;
	}

	@Override
	public PictureInfo savePicture(Account user, String root_path, File file,String filetype,String description)
			throws Exception {
		TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			//First save image to disk
			CommonMethod cm = CommonMethod.newInstance();
			String[] path = cm.saveImg(file, root_path,systemConfig.getUpload_pic(),ConsVar.IMG_WITH,filetype);
			//Save path and picture information to database
			Pictures p = new Pictures();
			p.setMin(path[0]);
			p.setThumb(path[1]);
			p.setLarge(path[2]);
			p.setFull(path[3]);
			Long id = picturesDAO.insert_return_id(p);
			p.setId(id);
			PicturesParameter pp = new PicturesParameter();
			pp.setIdPictures(id);
			pp.setDescription(description);
			pp.setUploadAccount(user.getAccount());
			pp.setUploadTime(new java.util.Date());
			pp.setStatus(PicturesParameter.STATUS_ALL);
			picturesParameterDAO.insert(pp);
			this.m_db_tx_manager.commit(status);
			//return the picture info
			PictureInfo pi = new PictureInfo();
			pi.setPictures(p);
			pi.setPicturesParameter(pp);
			return pi;
		}catch(Exception e){
			this.m_db_tx_manager.rollback(status);
			throw new java.lang.Exception(e.getMessage());
		}
	}

	@Override
	public List<PictureInfo> loadLatestPictures(long from_id) {
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, from_id, null, null, null);
	}

	@Override
	public List<PictureInfo> loadMoretPictures(long to_id, int size) {
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, null, to_id, 0, size);
	}

	@Override
	public List<PictureInfo> loadHomePictures(int size) {
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, null, null, 0, size);
	}

}
