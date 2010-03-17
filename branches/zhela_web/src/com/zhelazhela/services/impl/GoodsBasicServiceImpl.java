package com.zhelazhela.services.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.zhelazhela.db.dao.GoodsCommentDAO;
import com.zhelazhela.db.dao.GoodsDAO;
import com.zhelazhela.db.dao.GoodsPriceDAO;
import com.zhelazhela.db.dao.GoodsTrackDAO;
import com.zhelazhela.db.model.Goods;
import com.zhelazhela.db.model.GoodsComment;
import com.zhelazhela.db.model.define.UserComment;
import com.zhelazhela.domain.GoodCommentList;
import com.zhelazhela.domain.GoodsCollection;
import com.zhelazhela.domain.GoodsDetail;
import com.zhelazhela.domain.GoodsOfferList;
import com.zhelazhela.domain.SNSUser;
import com.zhelazhela.domain.UserGoodsList;
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
	
	private GoodsPriceDAO goodsPriceDAO;
		
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

	public void setGoodsPriceDAO(GoodsPriceDAO goodsPriceDAO) {
		this.goodsPriceDAO = goodsPriceDAO;
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
			goods.setGoodsType(gc.getGoods_type());
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
				commentGoods(record);
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
		//获取该商品被哪些用户关注,分页
		UserTrackList utl = loadUserTrack(id,user,sn,page,pagesize);
		gd.setTrackuser(utl);
		gd.setTrack_size(utl.getSize());
		//获取该商品的评论信息,分页
		GoodCommentList gcl = loadUserComment(id,sn,page,10);
		gd.setComment_size(gcl.getSize());
		gd.setComments(gcl);
		//获取该商品的销售提供信息
		GoodsOfferList gol = loadGoodsOffer(id,sn,page,pagesize);
		gd.setOffers(gol);
		gd.setOffer_size(gol.getSize());
		return gd;
	}

	public UserTrackList loadUserTrack(long id,SNSUser user, String sn,int page,int pagesize) throws Exception {
		UserTrackList utl = new UserTrackList();
		utl.setPage(page);
		utl.setPagesize(pagesize);
		if(user!=null){
			utl.setList(goodsTrackDAO.loadUserTrack(id,sn,user.getId(), user.getBeen_blocked(), page, pagesize));
			utl.setSize(goodsTrackDAO.countUserTrack(id,sn,user.getId(), user.getBeen_blocked()));
		}else{
			utl.setList(goodsTrackDAO.loadUserTrack(id,sn,null, null, page, pagesize));
			utl.setSize(goodsTrackDAO.countUserTrack(id,sn,null, null));
		}
		return utl;
	}
	
	public UserComment loadComment(long id) throws Exception{
		UserComment uc = goodsCommentDAO.loadComment(id);
		UserComment reply = null;
		UserComment tmp = null;
		if(uc!=null&&uc.getReply_id()>0){
			reply = loadComment(uc.getReply_id());
			tmp = uc;
			while(reply!=null){
				tmp.setReply_uc(reply);
				tmp = reply;
				if(tmp.getReply_id()>0){
					reply = goodsCommentDAO.loadComment(tmp.getReply_id());
				}
			}
		}
		return uc;
		
	}
	
	public GoodCommentList loadUserComment(long id,String sn,int page,int pagesize) throws Exception {
		GoodCommentList gcl = new GoodCommentList();
		gcl.setPage(page);
		gcl.setPagesize(pagesize);
		java.util.List<UserComment> list = goodsCommentDAO.loadUserComment(id, sn, page, pagesize);
		for(UserComment uc:list){
			if(uc.getReply_id()>0){
				uc.setReply_uc(loadComment(uc.getReply_id()));
			}
		}
		gcl.setList(list);
		gcl.setSize(goodsCommentDAO.countUserComment(id, sn));
		return gcl;
	}
	
	public GoodsOfferList loadGoodsOffer(long id,String sn,int page,int pagesize) throws Exception{
		GoodsOfferList gol = new GoodsOfferList();
		gol.setPage(page);
		gol.setPagesize(pagesize);
		gol.setList(goodsPriceDAO.loadUserPrice(id, sn, page, pagesize));
		gol.setSize(goodsPriceDAO.countUserPrice(id, sn));
		return gol;
	}

	@Override
	public UserGoodsList loadUserGoodsList(long userId, long loadUserId,
			int page, int pagesize,long tagid) throws Exception {
		UserGoodsList ugl = new UserGoodsList();
		ugl.setPage(page);
		ugl.setPagesize(pagesize);
		ugl.setSize(goodsTrackDAO.countUserGoodsbyUser(loadUserId,tagid));
		ugl.setList(goodsTrackDAO.loadUserGoodsbyUser(userId, loadUserId,tagid, page, pagesize));
		return ugl;
	}

	
	
	@Override
	public UserComment commentGoods(GoodsComment gc) throws Exception {
		gc.setUpdateTime(new java.util.Date());
		goodsCommentDAO.insert(gc);
		return loadComment(gc.getId());
	}

	@Override
	public UserGoodsList loadMyGoodsList(long userId, int page, int pagesize,long tagid)
			throws Exception {
		return loadUserGoodsList(userId,userId,page,pagesize,tagid);
	}

	@Override
	public UserGoodsList loadMyLatestList(long userId, int page, int pagesize)
			throws Exception {
		UserGoodsList ugl = new UserGoodsList();
		ugl.setPage(page);
		ugl.setPagesize(pagesize);
		ugl.setSize(goodsTrackDAO.countLatestGoodsbyUser(userId));
		ugl.setList(goodsTrackDAO.loadLatestGoodsbyUser(userId, page, pagesize));
		return ugl;
	}
}
