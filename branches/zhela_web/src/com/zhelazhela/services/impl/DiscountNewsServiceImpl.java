package com.zhelazhela.services.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.DiscountNewsDAO;
import com.zhelazhela.db.dao.AttachmentsDAO;
import com.zhelazhela.db.model.Attachments;
import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.db.model.DiscountNewsExample;
import com.zhelazhela.db.model.DiscountNewsExample.Criteria;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.UtilService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.util.CommonMethod;

public class DiscountNewsServiceImpl implements DiscountNewsService {

	private DiscountNewsDAO discountNewsDAO;
	
	private UtilService utilService;
	
	private AttachmentsDAO attachmentsDAO;
	
	private PlatformTransactionManager m_db_tx_manager;
	
	protected SystemConfig systemConfig;
	
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}
	
	@Override
	public boolean approveDiscountNews(long id, String approveUser,boolean result)
			throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			if(discountnews.getApproveResult()!=null&&discountnews.getApproveResult()==result){
				return true;
			}else{
				DiscountNews tmp = new DiscountNews();
				tmp.setId(id);
				tmp.setApproveResult(result);
				tmp.setApproveUser(approveUser);
				tmp.setApproveTime(new java.util.Date());
				discountNewsDAO.updateByPrimaryKeySelective(tmp);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delDiscountNews(long id) throws Exception {
		discountNewsDAO.deleteByPrimaryKey(id);
		return true;
	}

	@SuppressWarnings("static-access")
	@Override
	public DiscountNews editDiscountNews(long id, Long programId,
			String discountCategory, String discountArea, Date discountStart,
			Date discountEnd, String infoSource, String infoTitle,
			String infoReview, String infoContent) throws Exception {
		DiscountNews discountnews = new DiscountNews();
		discountnews.setId(id);
		if(programId!=null&&programId>0){
			discountnews.setpId(programId);
		}
		if(!StringUtils.isBlank(discountCategory)){
			discountCategory = discountCategory + discountnews.fatherStr + new java.util.ArrayList<String>(utilService.loadFatherCategorys(discountCategory)).toString().replaceAll(" ", "");
			discountnews.setDiscountCategory(discountCategory);
		}
		if(!StringUtils.isBlank(discountArea)){
			discountArea = discountArea + discountnews.fatherStr + new java.util.ArrayList<String>(utilService.loadFatherAreas(discountArea)).toString().replaceAll(" ", "");
			discountnews.setDiscountArea(discountArea);
		}
		if(discountStart!=null){
			discountnews.setDiscountStart(discountStart);
		}
		if(discountEnd!=null){
			discountnews.setDiscountEnd(discountEnd);
		}
		if(!StringUtils.isBlank(infoSource)){
			discountnews.setNewsSource(infoSource);
		}
		if(!StringUtils.isBlank(infoTitle)){
			discountnews.setNewsTitle(infoTitle);
		}
		if(!StringUtils.isBlank(infoReview)){
			discountnews.setNewsReview(infoReview);
		}
		if(!StringUtils.isBlank(infoContent)){
			discountnews.setNewsContent(infoContent);
		}
		int result  = discountNewsDAO.updateByPrimaryKeySelective(discountnews);
		if(result>0){
			discountnews = discountNewsDAO.selectByPrimaryKey(id);
			discountnews.removeFatherStr();
			return discountnews;
		}
		return null;
	}

	@Override
	public DiscountNewsList loadDiscountNewsList(int page,int pagesize,String categorys,String areas,String title,java.util.Date after_approve_time,String orderby,boolean andor)  throws Exception{
		java.util.List<String> _categorys = new java.util.ArrayList<String>(utilService.loadCategorys(categorys));
		java.util.List<String> _areas = new java.util.ArrayList<String>(utilService.loadAreas(areas));
		List<DiscountNews> list = null;
		int size = 0;
		if(andor){
			list = discountNewsDAO.selectWithPrgramInfoConditionAnd("not null", true, title, _categorys, _areas, orderby, page, pagesize);
			size = discountNewsDAO.countWithPrgramInfoConditionAnd("not null", true, title, _categorys, _areas);
		}else{
			list = discountNewsDAO.selectWithPrgramInfoConditionOr("not null", true, title, _categorys, _areas, orderby, page, pagesize);
			size = discountNewsDAO.countWithPrgramInfoConditionOr("not null", true, title, _categorys, _areas);
		}
		DiscountNewsList dnl = new DiscountNewsList();
		dnl.setList(list);
		dnl.setSize(size);
		dnl.setPage(page);
		dnl.setPagesize(pagesize);
		return dnl;
	}

	@Override
	public DiscountNews pointContent(long id, int points) throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			discountnews.setContentPointsTimes(discountnews.getContentPointsTimes()+1);
			discountnews.setContentPoints(discountnews.getContentPoints()+points);
			DiscountNews tmp = new DiscountNews();
			tmp.setId(id);
			tmp.setContentPointsTimes(discountnews.getContentPointsTimes());
			tmp.setContentPoints(discountnews.getContentPoints());
			discountNewsDAO.updateByPrimaryKeySelective(tmp);
			return discountnews;
		}
		return null;
	}

	@Override
	public DiscountNews pointPublish(long id, int points) throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			discountnews.setPublishPointsTimes(discountnews.getPublishPointsTimes()+1);
			discountnews.setPublishPoints(discountnews.getPublishPoints()+points);
			DiscountNews tmp = new DiscountNews();
			tmp.setId(id);
			tmp.setPublishPointsTimes(discountnews.getPublishPointsTimes());
			tmp.setPublishPoints(discountnews.getPublishPoints());
			discountNewsDAO.updateByPrimaryKeySelective(tmp);
			return discountnews;
		}
		return null;
	}

	@Override
	public long readDiscountNews(long id) throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			DiscountNews tmp = new DiscountNews();
			tmp.setId(id);
			tmp.setReadTimes(discountnews.getReadTimes()+1);
			discountNewsDAO.updateByPrimaryKeySelective(tmp);
			return tmp.getReadTimes();
		}
		return 0;
	}

	@SuppressWarnings("static-access")
	@Override
	public DiscountNews saveDiscountNews(DiscountNews discountnews)
			throws Exception {
		if(discountnews!=null){
			String discountCategory = discountnews.getDiscountCategory();
			if(!StringUtils.isBlank(discountCategory)){
				discountCategory = discountCategory + discountnews.fatherStr + new java.util.ArrayList<String>(utilService.loadFatherCategorys(discountCategory)).toString().replaceAll(" ", "");
				discountnews.setDiscountCategory(discountCategory);
			}
			String discountArea = discountnews.getDiscountArea();
			if(!StringUtils.isBlank(discountArea)){
				discountArea = discountArea + discountnews.fatherStr + new java.util.ArrayList<String>(utilService.loadFatherAreas(discountArea)).toString().replaceAll(" ", "");
				discountnews.setDiscountArea(discountArea);
			}
			long result = discountNewsDAO.insertSelectiveReturnId(discountnews);
			if(result>0){
				return discountNewsDAO.selectByPrimaryKey(result);
			}
		}
		return null;
	}

	@Override
	public long supportDiscountNews(long id) throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			DiscountNews tmp = new DiscountNews();
			tmp.setId(id);
			tmp.setSupportTimes(discountnews.getSupportTimes()+1);
			discountNewsDAO.updateByPrimaryKeySelective(tmp);
			return tmp.getSupportTimes();
		}
		return 0;
	}

	@Override
	public DiscountNews viewDiscountNews(long id) throws Exception{
		DiscountNews dn = discountNewsDAO.selectWithProgramInfoByPrimaryKey(id);
		if(dn!=null){
			dn.removeFatherStr();
		}
		return dn;
	}

	@Override
	public DiscountNewsList loadUnReleaseDiscountNewsList(int page,
			int pagesize, Map<String, Object> parameters, String categorys,
			String areas, String title,String orderby) throws Exception {

		DiscountNewsExample example = new DiscountNewsExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		Criteria criteria = example.createCriteria().andApproveResultNotEqualTo(true).andApproveUserIsNull();
		if(title!=null){
			criteria.andNewsTitleLike(title);
		}
		java.util.List<String> _categorys = new java.util.ArrayList<String>(utilService.loadCategorys(categorys));
		for(String category:_categorys){
			example.or(example.createCriteria().andApproveResultNotEqualTo(true).andApproveUserIsNull().andDiscountCategoryLike(category));
		}
		java.util.List<String> _areas = new java.util.ArrayList<String>(utilService.loadAreas(areas));
		for(String _area:_areas){
			example.or(example.createCriteria().andApproveResultNotEqualTo(true).andApproveUserIsNull().andDiscountAreaLike(_area));
		}
		if(orderby!=null){
			example.setOrderByClause(orderby);
		}
		List<DiscountNews> list = discountNewsDAO.selectWithProgramInfoByExampleWithoutBLOBs(example);
		int size = discountNewsDAO.countByExample(example);
		DiscountNewsList dnl = new DiscountNewsList();
		dnl.setList(list);
		dnl.setSize(size);
		dnl.setPage(page);
		dnl.setPagesize(pagesize);
		return dnl;
	}


	@Override
	public Attachments uploadPic(Attachments record, String rootPath,
			String filetype, File pic) throws Exception {
		if(pic!=null&&pic.length()>systemConfig.getUpload_pic_maxlength()){
			throw new Exception("上次文件大小超过"+systemConfig.getUpload_pic_maxlength()/(1024*1024)+"MB限制");
		}
		TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			if(pic!=null){
				CommonMethod cm = CommonMethod.newInstance();
				record.setFileName(cm.saveLogo(pic, rootPath, systemConfig.getUpload_pic(), filetype));
			}
			long result = attachmentsDAO.insertSelectiveReturnId(record);
			if(result>0){
				this.m_db_tx_manager.commit(status);
				return attachmentsDAO.selectByPrimaryKey(result);
			}else{
				this.m_db_tx_manager.rollback(status);
				throw new java.lang.Exception("上传图片失败");
			}
		}catch(Exception e){
			this.m_db_tx_manager.rollback(status);
			throw new java.lang.Exception(e.getMessage());
		}
	}
	
	public void setDiscountNewsDAO(DiscountNewsDAO discountNewsDAO) {
		this.discountNewsDAO = discountNewsDAO;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}

	
	public void setAttachmentsDAO(AttachmentsDAO attachmentsDAO) {
		this.attachmentsDAO = attachmentsDAO;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}	
	
}
