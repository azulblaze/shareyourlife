package com.twitpic.services;

public interface CollectionService {
	/**
	 * create a collection name
	 * @param account
	 * @param collection
	 * @return
	 * @throws Exception
	 */
	public com.twitpic.db.model.Collection create_collection(String account,com.twitpic.db.model.Collection collection) throws Exception;
	/**
	 * update the collection,you can update the collection's name, cover and description
	 * @param account
	 * @param collection
	 * @return
	 * @throws Exception
	 */
	public com.twitpic.db.model.Collection update_collection(String account,com.twitpic.db.model.Collection collection) throws Exception;
	/**
	 * delete the collection and all the collection pictures
	 * @param account
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete_collection(String account,Long id) throws Exception;
	/**
	 * bind the picture to the collection
	 * @param account
	 * @param id_picture
	 * @param id_collection
	 * @return
	 * @throws Exception
	 */
	public boolean bind_collection(String account,Long id_picture,Long id_collection) throws Exception;
	/**
	 * unbind the picture to the collection
	 * @param account
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean unbind_collection(String account,Long id) throws Exception;
	/**
	 * bind the picture to the collection
	 * @param account
	 * @param id_picture
	 * @param collection
	 * @return
	 * @throws Exception
	 */
	public boolean bind_collection(String account,Long id_picture,com.twitpic.db.model.Collection collection) throws Exception;
}
