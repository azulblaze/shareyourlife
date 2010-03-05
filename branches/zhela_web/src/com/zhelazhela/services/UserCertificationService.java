package com.zhelazhela.services;

import com.zhelazhela.db.model.Certification;

public interface UserCertificationService {
	/**
	 * 真实身份认证
	 */
	public final static String ID_CERT = "idcert";
	/**
	 * 认证卖家
	 */
	public final static String SELLER = "seller";
	/**
	 * 认证管理员
	 */
	public final static String MANAGER = "manager";
	
	public static java.util.List<String> CERTS = new java.util.ArrayList<String>();

	public boolean applyCertification(long myId,long user_id,String certName,java.util.Date start,java.util.Date end) throws Exception;
	
	public Certification editCertification(long myId,long user_id,long usercertId,String certName,java.util.Date start,java.util.Date end) throws Exception;
	
	public boolean cancelCertification(long myId,long cert_id) throws Exception;
}
