package com.twitpic.services.impl;

import java.util.List;

import com.twitpic.db.model.Collection;
import com.twitpic.db.model.CollectionExample;
import com.twitpic.db.model.PicturesParameter;
import com.twitpic.db.model.PicturesCollection;
import com.twitpic.db.model.PicturesCollectionExample;
import com.twitpic.services.CollectionService;
import com.twitpic.db.dao.CollectionDAO;
import com.twitpic.db.dao.PicturesCollectionDAO;
import com.twitpic.db.dao.PicturesParameterDAO;

public class CollectionServiceImpl implements CollectionService {
	
	private CollectionDAO collectionDAO;
	
	private PicturesCollectionDAO picturesCollectionDAO;
	
	private PicturesParameterDAO picturesParameterDAO;

	public void setCollectionDAO(CollectionDAO collectionDAO) {
		this.collectionDAO = collectionDAO;
	}

	public void setPicturesCollectionDAO(PicturesCollectionDAO picturesCollectionDAO) {
		this.picturesCollectionDAO = picturesCollectionDAO;
	}

	public void setPicturesParameterDAO(PicturesParameterDAO picturesParameterDAO) {
		this.picturesParameterDAO =picturesParameterDAO;
	}

	@Override
	public boolean bind_collection(String account, Long idPicture,
			Long idCollection) throws Exception {
		//first check if the picture is already collected!
		if(picturesCollectionDAO.count_collection_picture(account, idPicture, null)>0){
			return false;
		}
		//check if the collection and picture is exist
		Collection collection = collectionDAO.selectByPrimaryKey(idCollection);
		PicturesParameter picturesParameter = picturesParameterDAO.selectByPrimaryKey(idPicture);
		//if collection is belong to this account,save record!
		//use only collect the picture that don't belong to him
		if(collection!=null&&picturesParameter!=null&&(!picturesParameter.getUploadAccount().equals(account))&&collection.getAccount().equals(account)){
			PicturesCollection record = new PicturesCollection();
			record.setCreateTime(new java.util.Date());
			record.setIdCollections(idCollection);
			record.setIdPictures(idPicture);
			picturesCollectionDAO.insert(record);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean bind_collection(String account, Long idPicture,
			Collection collection) throws Exception {
		//first check if the collection is already exist
		CollectionExample ce = new CollectionExample();
		ce.createCriteria().andAccountEqualTo(account).andNameEqualTo(collection.getName());
		java.util.List<Collection> collections = collectionDAO.selectByExample(ce);
		if(collections.size()>0){
			collection = collections.get(0);
			//if exist,need to check if the picture is already collected
			if(picturesCollectionDAO.count_collection_picture(account, idPicture, null)>0){
				return false;
			}
		}else{
			//if not exist,save it!
			collection.setAccount(account);
			collection.setCreateTime(new java.util.Date());
			collection.setId(collectionDAO.insert_return_id(collection));
		}
		collection.setId(collectionDAO.insert_return_id(collection));
		PicturesParameter picturesParameter = picturesParameterDAO.selectByPrimaryKey(idPicture);
		//use only collect the picture that don't belong to him
		if(picturesParameter!=null&&(!picturesParameter.getUploadAccount().equals(account))){
			PicturesCollection record = new PicturesCollection();
			record.setCreateTime(new java.util.Date());
			record.setIdCollections(collection.getId());
			record.setIdPictures(idPicture);
			picturesCollectionDAO.insert(record);
			return true;
		}
		return false;
	}
	
	@Override
	public Collection create_collection(String account, Collection collection) throws Exception {
		CollectionExample ce = new CollectionExample();
		ce.createCriteria().andAccountEqualTo(account).andNameEqualTo(collection.getName());
		if(collectionDAO.selectByExample(ce).size()>0){
			throw new Exception("不能重复创建收藏夹");
		}
		if(collection.getCover()!=null&&collection.getCover()>0){
			collection.setCover(0l);
			//usually we only allowed user use his pictures or the pictures that belong to this collection to cover!
			//cause first create collection, we set cover to zero
		}
		collection.setAccount(account);
		collection.setCreateTime(new java.util.Date());
		collection.setId(collectionDAO.insert_return_id(collection));
		return collection;
	}

	@Override
	public boolean delete_collection(String account, Long id) throws Exception {
		Collection collection = collectionDAO.selectByPrimaryKey(id);
		if(collection!=null&&collection.getAccount().equals(account)){
			PicturesCollectionExample pce = new PicturesCollectionExample();
			pce.createCriteria().andIdCollectionsEqualTo(id);
			picturesCollectionDAO.selectByExample(pce);
			collectionDAO.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean unbind_collection(String account, Long id) throws Exception {
		PicturesCollection picturesCollection = picturesCollectionDAO.selectByPrimaryKey(id);
		if(picturesCollection!=null){
			Collection collection = collectionDAO.selectByPrimaryKey(picturesCollection.getIdCollections());
			if(collection!=null&&collection.getAccount().equals(account)){
				picturesCollectionDAO.deleteByPrimaryKey(id);
				if(collection.getCover()!=null&&collection.getCover().longValue()==id){
					//if the collection picture is the colletion's cover,set collection's cover to zero
					collection.setCover(0l);
					collectionDAO.updateByPrimaryKey(collection);
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection update_collection(String account, Collection collection) throws Exception {
		Collection tmp = collectionDAO.selectByPrimaryKey(collection.getId());
		if(collection.getName()==null||collection.getName().trim().length()<1){
			collection.setName(tmp.getName());
		}
		if(collection.getName()!=null&&(!collection.equals(tmp.getName()))){
			CollectionExample ce = new CollectionExample();
			ce.createCriteria().andAccountEqualTo(account).andNameEqualTo(collection.getName());
			java.util.List<Collection> tmps = collectionDAO.selectByExample(ce);
			if(tmps.size()>0){
				throw new Exception("您修改得目标名字已经存在了");
			}
		}
		if(collection.getCover()!=null&&collection.getCover()>0){
			//usually we only allowed user use his pictures or the pictures that belong to this collection to cover!
			PicturesCollectionExample pce = new PicturesCollectionExample();
			pce.createCriteria().andIdCollectionsEqualTo(collection.getId()).andIdPicturesEqualTo(collection.getCover());
			if(picturesCollectionDAO.selectByExample(pce).size()==0){
				throw new Exception("您必须选字该收藏夹的图片作为封面");
			}
		}
		if(tmp.getAccount().equals(account)){
			collectionDAO.updateByPrimaryKey(collection);
		}
		return collection;
	}

	@Override
	public List<Collection> select_all_collections(String account) {
		CollectionExample ce = new CollectionExample();
		ce.createCriteria().andAccountEqualTo(account);
		return collectionDAO.select_with_count_ByExample(ce);
	}

	@Override
	public Collection select_collection(String account, Long id) {
		Collection collection = collectionDAO.select_with_count_ByPrimaryKey(id);
		if(collection!=null&&collection.getAccount().equals(account)){
			return collection;
		}
		return null;
	}

}
