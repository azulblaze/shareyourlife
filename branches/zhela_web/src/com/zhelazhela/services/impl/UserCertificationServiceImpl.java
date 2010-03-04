package com.zhelazhela.services.impl;

import java.util.Date;

import com.zhelazhela.db.dao.CertificationDAO;
import com.zhelazhela.db.dao.UserCertificationDAO;
import com.zhelazhela.db.model.Certification;
import com.zhelazhela.services.UserCertificationService;

public class UserCertificationServiceImpl implements UserCertificationService {
	
	static{
		CERTS.add(ID_CERT);
		CERTS.add(SELLER);
		CERTS.add(MANAGER);
	}
	
	private UserCertificationDAO userCertificationDAO;

	private CertificationDAO certificationDAO;
	
	public void setUserCertificationDAO(UserCertificationDAO userCertificationDAO) {
		this.userCertificationDAO = userCertificationDAO;
	}

	public void setCertificationDAO(CertificationDAO certificationDAO) {
		this.certificationDAO = certificationDAO;
	}
	
	@Override
	public boolean applyCertification(long myId, long userId, String certName,
			Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelCertification(long myId, long certId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Certification editCertification(long myId, long userId,
			String certName, Date start, Date end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
