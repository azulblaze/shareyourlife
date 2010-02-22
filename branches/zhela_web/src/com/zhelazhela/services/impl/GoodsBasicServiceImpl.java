package com.zhelazhela.services.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.GoodsCommentDAO;
import com.zhelazhela.db.dao.GoodsDAO;
import com.zhelazhela.db.dao.GoodsTrackDAO;
import com.zhelazhela.db.model.Goods;
import com.zhelazhela.db.model.GoodsComment;
import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.UserTrackList;
import com.zhelazhela.services.GoodsBasicService;
import com.zhelazhela.services.GoodsRelationService;
import com.zhelazhela.system.config.SystemConfig;
import com.zhelazhela.util.CommonMethod;

public class GoodsBasicServiceImpl implements GoodsBasicService {
	
	private PlatformTransactionManager m_db_tx_manager;
	
	private SystemConfig systemConfig;
	
	private GoodsDAO goodsDAO;
	
	private GoodsCommentDAO goodsCommentDAO;
	
	private GoodsRelationService goodsRelationService;
	
	private GoodsTrackDAO goodsTrackDAO;
	
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public void setGoodsCommentDAO(GoodsCommentDAO goodsCommentDAO) {
		this.goodsCommentDAO = goodsCommentDAO;
	}

	public void setGoodsRelationService(GoodsRelationService goodsRelationService) {
		this.goodsRelationService = goodsRelationService;
	}

	public void setGoodsTrackDAO(GoodsTrackDAO goodsTrackDAO) {
		this.goodsTrackDAO = goodsTrackDAO;
	}

	@Override
	public GoodsDetail addSiteGoods(GoodsCollection gc) throws Exception {
		TransactionStatus status = m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
		try{
			Goods goods = new Goods();
			goods.setCategory(gc.getCategory());
			goods.setDescription(gc.getDesc());
			//need to upload pic
			String[] path = CommonMethod.newInstance().saveGoodPic(gc.getPic(), gc.getRoot_path(), systemConfig.getUpload_good_pic());
			goods.setIcon(path[0]);
			goods.setPicture(path[1]);
			//others
			goods.setSn("");
			goods.setSource(gc.getSource());
			goods.setTopic(gc.getName());
			goods.setUpdateTime(new java.util.Date());
			goodsDAO.insertSelective(goods);
			
			//save track
			if(gc.getTag_id()>0){
				goodsRelationService.track(goods.getId(), null, gc.getUser_id(), gc.getRate(), gc.getTag_id(), gc.getPrivacy(), gc.getTrack_price());
			}else{
				goodsRelationService.track(goods.getId(), null, gc.getUser_id(), gc.getRate(), gc.getTag(), gc.getPrivacy(), gc.getTrack_price());
			}
			
			//save comment
			if(gc.getComment()!=null&&gc.getComment().trim().length()>0){
				GoodsComment record = new GoodsComment();
				record.setGoodsId(goods.getId());
				record.setContent(gc.getComment());
				record.setRepliedId(0l);
				record.setSn(null);
				record.setUpdateTime(new java.util.Date());
				record.setUserId(gc.getUser_id());
				goodsCommentDAO.insert(record);
			}
			m_db_tx_manager.commit(status);
			return new GoodsDetail();
		}catch(Exception e){
			m_db_tx_manager.rollback(status);
			throw e;
		}
	}

	@Override
	public GoodsDetail loadGoodsDetail(long id,SNSUser user, String sn,int page,int pagesize) throws Exception {
		Goods g = goodsDAO.selectByPrimaryKey(id);
		if(g==null){
			return null;
		}
		GoodsDetail gd = new GoodsDetail();
		gd.setGoods(g);
		UserTrackList utl = new UserTrackList();
		utl.setPage(page);
		utl.setPagesize(pagesize);
		if(user!=null){
			utl.setList(goodsTrackDAO.loadUserTrack(user.getId(), user.getBeen_blocked(), page, pagesize));
			utl.setSize(goodsTrackDAO.countUserTrack(user.getId(), user.getBeen_blocked()));
		}else{
			utl.setList(goodsTrackDAO.loadUserTrack(null, null, page, pagesize));
			utl.setSize(goodsTrackDAO.countUserTrack(null, null));
		}
		gd.setTrackuser(utl);
		gd.setTrack_size(utl.getSize());
		//gd.setComment_size(commentSize)
		return gd;
	}

}
