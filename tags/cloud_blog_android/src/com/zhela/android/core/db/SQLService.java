package com.zhela.android.core.db;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zhela.android.core.db.model.Image;
import com.zhela.android.core.db.model.Provider;
import com.zhela.android.core.db.model.ProviderAccount;
import com.zhela.android.core.db.model.User;

public class SQLService {

	private SQLiteFactory sqf;
	
	public SQLService(){
		sqf =SQLiteFactory.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public User getDefaultUsers(){
		List<User> users;
		try {
			users = (List<User>)sqf.loadList("select * from users where is_default='true'", User.class);
			if(users.size()>=0){
				return users.get(0);
			}
		} catch (Exception e) {
			
		}
		return null;
	}
	public int getUserCount(){
		return sqf.loadModelCount("select count(*) from users"); 
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		List<User> users;
		try {
			users = (List<User>)sqf.loadList("select * from "+User.TABLE_NAME, User.class);
			if(users!=null){
				return users;
			}
		} catch (Exception e) {
			
		}
		return new ArrayList<User>();
	}
	
	public int getUserProviderCount(String account){
		return sqf.loadModelCount("select count(*) from "+ProviderAccount.TABLE_NAME+" where account='"+account+"'"); 
	}
	
	@SuppressWarnings("unchecked")
	public int updateOrInsertUser(User users,String where,Set<String> field){
		if(where==null&&field==null){
			users.update_time = new java.util.Date();
			sqf.saveModel(users);
			return 1;
		}
		int size = 0;
		try {
			size = ((List<User>)sqf.loadList("select * from users where account='"+users.account+"'", User.class)).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(size>0){
			return sqf.updateModel(users, where, field);
		}else{
			users.update_time = new java.util.Date();
			sqf.saveModel(users);
			return 1;
		}
	}
	public void reSetDefaultUser(){
		sqf.equals("update users set is_default='false' where is_default='true'");
	}
	
	@SuppressWarnings("unchecked")
	public Image getImageWithURL(String url){
		List<Image> images = null;
		try {
			images = (List<Image>)sqf.loadList("select * from images where url='"+url+"'", Image.class);
		} catch (Exception e) {
			
		}
		if(images!=null&&images.size()>0){
			return images.get(0);
		}
		return null;
	}
	
	public void insertOrUpdateImage(Image image){
		Image _image = getImageWithURL(image.url);
		if(_image!=null){
			_image.bitimg = image.bitimg;
			_image.update_time = new java.util.Date();
			Set<String> field = new HashSet<String>();
			field.add("bitimg");
			field.add("update_time");
			sqf.updateModel(_image, " id="+_image.id, field);
		}else{
			sqf.saveModel(image);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Provider> loadAllProviders(){
		try {
			return (List<Provider>)sqf.loadList("select * from "+Provider.TABLE_NAME+"", Provider.class);
		} catch (Exception e) {
			return new ArrayList<Provider>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Provider loadProviderById(long id){
		try {
			List<Provider> providers = (List<Provider>)sqf.loadList("select * from "+Provider.TABLE_NAME+" where id="+id, Provider.class);
			if(providers!=null&&providers.size()>0){
				return providers.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProviderAccount> loadProviderAccount(String account){
		try {
			List<ProviderAccount> provideraccounts = (List<ProviderAccount>)sqf.loadList("select * from "+ProviderAccount.TABLE_NAME+" where account='"+account+"'", ProviderAccount.class);
			if(provideraccounts!=null){
				return provideraccounts;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ProviderAccount>();
	}
}
