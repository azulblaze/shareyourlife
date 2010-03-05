package com.zhelazhela.services.impl;

import java.util.Date;

import com.zhelazhela.db.dao.CertificationDAO;
import com.zhelazhela.db.dao.UserCertificationDAO;
import com.zhelazhela.db.model.Certification;
import com.zhelazhela.db.model.CertificationExample;
import com.zhelazhela.db.model.UserCertification;
import com.zhelazhela.services.UserCertificationService;

public class UserCertificationServiceImpl implements UserCertificationService {
	
	static{
		CERTS.add(ID_CERT);
		CERTS.add(SELLER);
		CERTS.add(MANAGER);
	}
	
	private UserCertificationDAO userCertificationDAO;

	private CertificationDAO certificationDAO;
	
	public static java.util.List<Certification> cert_list;
	
	public void setUserCertificationDAO(UserCertificationDAO userCertificationDAO) {
		this.userCertificationDAO = userCertificationDAO;
	}

	public void setCertificationDAO(CertificationDAO certificationDAO) {
		this.certificationDAO = certificationDAO;
	}
	/**
	 * find cert by name
	 * @param name
	 * @return
	 */
	private Certification findCert(String name){
		if(cert_list==null){
			cert_list = certificationDAO.selectByExample(new CertificationExample());
		}
		for(Certification c:cert_list){
			if(c.getName().equals(name)){
				return c;
			}
		}
		CertificationExample cce = new CertificationExample();
		cce.createCriteria().andNameEqualTo(name);
		java.util.List<Certification> tmp = certificationDAO.selectByExample(cce);
		if(tmp.size()>0){
			cert_list.add(tmp.get(0));
			return tmp.get(0);
		}
		return null;
	}
	/**
	 * find cert by id
	 * @param id
	 * @return
	 */
	private Certification findCert(long id){
		if(cert_list==null){
			cert_list = certificationDAO.selectByExample(new CertificationExample());
		}
		for(Certification c:cert_list){
			if(c.getId().equals(id)){
				return c;
			}
		}
		Certification tmp = certificationDAO.selectByPrimaryKey(id);
		if(tmp!=null){
			cert_list.add(tmp);
			return tmp;
		}
		return null;
	}
	
	@Override
	public boolean applyCertification(long myId, long userId, String certName,
			Date start, Date end) throws Exception {
		Certification cf = findCert(certName);
		if(cf==null){
			throw new Exception("没有该认证");
		}
		UserCertification record = new UserCertification();
		record.setCertId(cf.getId());
		record.setEndDate(end);
		record.setStartDate(start);
		record.setUserId(userId);
		record.setParameter(myId+"");
		userCertificationDAO.insert(record);
		return true;
	}

	@Override
	public boolean cancelCertification(long myId, long certId) throws Exception {
		int row = certificationDAO.deleteByPrimaryKey(certId);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public Certification editCertification(long myId, long userId,long usercertId,
			String certName, Date start, Date end) throws Exception {
		UserCertification record = userCertificationDAO.selectByPrimaryKey(usercertId);
		if(record==null||!record.getUserId().equals(userId)){
			throw new Exception("您还没有通过该认证");
		}
		boolean update = false;
		Certification tmp = findCert(certName);
		if(tmp!=null&&!record.getCertId().equals(tmp.getId())){
			record.setCertId(tmp.getId());
			update = true;
		}
		if(!record.getStartDate().equals(start)){
			record.setStartDate(start);
			update = true;
		}
		if(!record.getEndDate().equals(end)){
			record.setEndDate(end);
			update = true;
		}
		if(update){
			userCertificationDAO.updateByPrimaryKey(record);
		}
		return findCert(record.getCertId());
	}

}
