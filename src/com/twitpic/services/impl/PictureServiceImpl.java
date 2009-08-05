package com.twitpic.services.impl;

import java.io.File;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.twitpic.db.dao.CommentsDAO;
import com.twitpic.db.dao.PicturesDAO;
import com.twitpic.db.dao.PicturesParameterDAO;
import com.twitpic.db.dao.TagsDAO;
import com.twitpic.db.dao.TagsRelDAO;
import com.twitpic.db.model.Comments;
import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesParameter;
import com.twitpic.db.model.Tags;
import com.twitpic.db.model.TagsExample;
import com.twitpic.db.model.TagsRel;
import com.twitpic.db.model.TagsRelExample;
import com.twitpic.domain.FormComment;
import com.twitpic.domain.FormTag;
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
	
	private CommentsDAO commentsDAO;
	
	private PicturesParameterDAO picturesParameterDAO;
	
	private TagsDAO tagsDAO;
	
	private TagsRelDAO tagsRelDAO;
	
	public void setTagsRelDAO(TagsRelDAO tagsRelDAO){
		this.tagsRelDAO = tagsRelDAO;
	}
	public void setTagsDAO(TagsDAO tagsDAO){
		this.tagsDAO = tagsDAO;
	}
	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}
	
	public void setTxManager(PlatformTransactionManager tx){
		this.m_db_tx_manager = tx;
	}
	
	public void setPicturesDAO(PicturesDAO picturesDAO) {
		this.picturesDAO = picturesDAO;
	}

	public void setCommentsDAO(CommentsDAO commentsDAO){
		this.commentsDAO = commentsDAO;
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
	public PictureInfo savePicture(Account user, String root_path, File file,String filetype,String description,String title)
			throws Exception {
		if(file.length()>systemConfig.getUpload_pic_maxlength()){
			throw new Exception("上次文件大小超过"+systemConfig.getUpload_pic_maxlength()/(1024*1024)+"MB限制");
		}
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
			pp.setTitle(title);
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
	public List<PictureInfo> loadLatestPictures(long from_id) throws Exception{
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, from_id, null, null, null);
	}

	@Override
	public List<PictureInfo> loadMoretPictures(long to_id, int size) throws Exception{
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, null, to_id, 0, size);
	}

	@Override
	public List<PictureInfo> loadHomePictures(int size) throws Exception{
		return picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, null, null, null, null, 0, size);
	}

	@Override
	public Comments comment(Account account, FormComment formComment) throws Exception{
		List<PictureInfo> list = picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, formComment.getId_pictures(), null, null, null, null, null);
		if(list.size()>0){
			Comments c = new Comments();
			c.setAccount(account.getAccount());
			c.setComment(formComment.getComment());
			c.setIdPictures(formComment.getId_pictures());
			c.setCommentTime(new java.util.Date());
			Long id = commentsDAO.insert_return_id(c);
			c.setId(id);
			return c;
		}else{
			throw new Exception("您要评论的图片不存在");
		}
	}

	@Override
	public PictureInfo loadPicture(long id_picture) throws Exception {
		List<PictureInfo> list = picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, id_picture, null, null, null, null, null);
		if(list.size()>0){
			return list.get(0);
		}
		throw new Exception("未找到该图片，可能已经被删除");
	}

	@Override
	public Tags Tag(Account account, FormTag formTag) throws Exception {
		List<PictureInfo> list = picturesDAO.findPicturesInfo(PicturesParameter.STATUS_ALL, formTag.getId_pictures(), null, null, null, null, null);
		if(list.size()>0){
			TagsExample te = new TagsExample();
			te.createCriteria().andNameEqualTo(formTag.getName());
			List<Tags> tags = tagsDAO.selectByExample(te);
			if(tags.size()>0){
				saveTagRel(account,formTag.getId_pictures(),tags.get(0).getId());
				return tags.get(0);
			}else{
				TransactionStatus  status = this.m_db_tx_manager.getTransaction(new DefaultTransactionDefinition());
				try{
					Tags tag = new Tags();
					tag.setAccount(account.getAccount());
					tag.setCreateTime(new java.util.Date());
					tag.setDescription("");
					tag.setName(formTag.getName());
					tag.setStatus(Tags.STATUS_USER);
					Long id = tagsDAO.insert_return_id(tag);
					tag.setId(id);
					saveTagRel(account,formTag.getId_pictures(),tag.getId());
					this.m_db_tx_manager.commit(status);
					return tag;
				}catch(Exception e){
					this.m_db_tx_manager.rollback(status);
					throw new Exception("标记失败");
				}
			}
		}else{
			throw new Exception("您要标记的图片不存在");
		}
	}

	private void saveTagRel(Account account,Long id_pictures,Long id_tags){
		TagsRelExample example = new TagsRelExample();
		example.createCriteria().andAccountEqualTo(account.getAccount()).andIdPicturesEqualTo(id_pictures).andIdTagsEqualTo(id_tags);
		java.util.List<TagsRel> tagsRels = tagsRelDAO.selectByExample(example);
		if(tagsRels.size()>0){
			TagsRel tagsRel = tagsRels.get(0);
			tagsRel.setTagTime(new java.util.Date());
			tagsRelDAO.updateByPrimaryKeySelective(tagsRel);
		}else{
			TagsRel tagsRel = new TagsRel();
			tagsRel.setAccount(account.getAccount());
			tagsRel.setIdPictures(id_pictures);
			tagsRel.setIdTags(id_tags);
			tagsRel.setTagTime(new java.util.Date());
			tagsRelDAO.insert(tagsRel);
		}
	}
}
