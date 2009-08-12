package com.twitpic.services.impl;

import com.twitpic.db.dao.AdminsDAO;
import com.twitpic.db.dao.PicturesDAO;
import com.twitpic.db.dao.PicturesParameterDAO;
import com.twitpic.db.dao.UsersDAO;
import com.twitpic.db.model.Admins;
import com.twitpic.db.model.AdminsExample;
import com.twitpic.db.model.Pictures;
import com.twitpic.db.model.PicturesParameter;
import com.twitpic.db.model.Users;
import com.twitpic.domain.FormLogin;
import com.twitpic.domain.PictureInfoList;
import com.twitpic.services.AdminService;
import com.twitpic.util.CommonMethod;

/**
 * <code>AdminServiceImpl.java</code>
 * @version 1.0, 2009-8-12
 */
public class AdminServiceImpl implements AdminService {
	
	
	private AdminsDAO adminsDAO;
	
	private PicturesDAO picturesDAO;
	
	private PicturesParameterDAO picturesParameterDAO;
	
	private UsersDAO usersDAO;

	@Override
	public PictureInfoList loadPictures(long from, long to, int size) {
		PictureInfoList pi = new PictureInfoList();
		if(from>0&&to>0){
			pi.setPis(picturesDAO.findPicturesInfo(null, null, null, from, to, null, null));
		}else{
			if(from>0){
				pi.setPis(picturesDAO.findPicturesInfo(null, null, null, from, null, 0, size));
			}else{
				if(to>0){
					pi.setPis(picturesDAO.findPicturesInfo(null, null, null, null, to, 0, size));
				}
			}
		}
		return pi;
	}

	@Override
	public Admins user_login(FormLogin formLogin) throws Exception {
		AdminsExample ae = new AdminsExample();
		ae.createCriteria().andAccountEqualTo(formLogin.getName()).andPasswordEqualTo(formLogin.getPassword());
		java.util.List<Admins> lists = adminsDAO.selectByExample(ae);
		if(lists.size()>0){
			return lists.get(0);
		}
		return null;
	}

	@Override
	public boolean deletePictures(String root_path,Long id_picture) {
		if(id_picture>0){
			try{
				Pictures p = picturesDAO.selectByPrimaryKey(id_picture);
				if(p!=null){
					CommonMethod cm = CommonMethod.newInstance();
					cm.deleteFile(root_path+p.getFull());
					cm.deleteFile(root_path+p.getLarge());
					cm.deleteFile(root_path+p.getThumb());
					cm.deleteFile(root_path+p.getMin());
				}
				picturesDAO.deleteByPrimaryKey(id_picture);
				picturesParameterDAO.deleteByPrimaryKey(id_picture);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean disablePictures(Long id_picture) {
		if(id_picture>0){
			try{
				PicturesParameter pp = picturesParameterDAO.selectByPrimaryKey(id_picture);
				if(pp!=null){
					pp.setStatus(PicturesParameter.STATUS_DISABEL);
					picturesParameterDAO.updateByPrimaryKeySelective(pp);
				}
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean disableUser(String account) {
		if(account!=null){
			try{
				Users user = usersDAO.selectByPrimaryKey(account);
				if(user!=null){
					user.setStatus(Users.STATUS_CLOSED);
					usersDAO.updateByPrimaryKeySelective(user);
				}
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	
	/**
	 * @param adminsDAO the adminsDAO to set
	 */
	public void setAdminsDAO(AdminsDAO adminsDAO) {
		this.adminsDAO = adminsDAO;
	}

	/**
	 * @param picturesDAO the picturesDAO to set
	 */
	public void setPicturesDAO(PicturesDAO picturesDAO) {
		this.picturesDAO = picturesDAO;
	}
	
	/**
	 * @param picturesParameterDAO the picturesParameterDAO to set
	 */
	public void setPicturesParameterDAO(PicturesParameterDAO picturesParameterDAO) {
		this.picturesParameterDAO = picturesParameterDAO;
	}

	/**
	 * @param usersDAO the usersDAO to set
	 */
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	
}
