package com.zhelazhela.services.impl;

import java.util.Date;
import java.util.Map;

import com.zhelazhela.db.dao.DiscountNewsDAO;
import com.zhelazhela.db.model.DiscountNews;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.DiscountNewsService;

public class DiscountNewsServiceImpl implements DiscountNewsService {

	private DiscountNewsDAO discountNewsDAO;
	
	@Override
	public boolean approveDiscountNews(long id, String approveUser,boolean result)
			throws Exception {
		DiscountNews discountnews = discountNewsDAO.selectByPrimaryKey(id);
		if(discountnews!=null){
			if(discountnews.getApproveResult()==result){
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

	@Override
	public DiscountNews editDiscountNews(long id, Long programId,
			String discountCategory, String discountArea, Date discountStart,
			Date discountEnd, String infoSource, String infoTitle,
			String infoReview, String infoContent) throws Exception {
		DiscountNews discountnews = new DiscountNews();
		discountnews.setId(id);
		if(discountnews!=null){
			if(programId!=null&&programId>0){
				discountnews.setpId(programId);
			}
			if(discountCategory!=null){
				discountnews.setDiscountCategory(discountCategory);
			}
			if(discountArea!=null){
				discountnews.setDiscountArea(discountArea);
			}
			if(discountStart!=null){
				discountnews.setDiscountStart(discountStart);
			}
			if(discountEnd!=null){
				discountnews.setDiscountEnd(discountEnd);
			}
			if(infoSource!=null){
				discountnews.setNewsSource(infoSource);
			}
			if(infoTitle!=null){
				discountnews.setNewsTitle(infoTitle);
			}
			if(infoReview!=null){
				discountnews.setNewsReview(infoReview);
			}
			if(infoContent!=null){
				discountnews.setNewsContent(infoContent);
			}
			int result  = discountNewsDAO.updateByPrimaryKeySelective(discountnews);
			if(result>0){
				return discountNewsDAO.selectByPrimaryKey(id);
			}
		}
		return null;
	}

	@Override
	public DiscountNewsList loadDiscountNewsList(int page, int pagesize,
			Map<String, String> parameters)  throws Exception{
		//throw new Exception("un implements");
		return null;
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

	@Override
	public DiscountNews saveDiscountNews(DiscountNews discountnews)
			throws Exception {
		if(discountnews!=null){
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
		//throw new Exception("un implements");
		return null;
	}

	@Override
	public DiscountNewsList loadUnReleaseDiscountNewsList(int page, int pagesize) throws Exception{
		//throw new Exception("un implements");
		return null;
	}

	public void setDiscountNewsDAO(DiscountNewsDAO discountNewsDAO) {
		this.discountNewsDAO = discountNewsDAO;
	}
	
	
	
}
