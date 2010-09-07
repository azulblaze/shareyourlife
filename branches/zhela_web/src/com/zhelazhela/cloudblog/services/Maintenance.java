package com.zhelazhela.cloudblog.services;

import com.zhelazhela.cloudblog.domain.ACK;

public interface Maintenance {

	public static final String APP_KEY  = "846676903732584882l";
	
	/**
	 * domain.com/dev/test
	 * GET
	 * @param parameters
	 * @return
	 */
	public ACK testNetwork(java.util.Map<String,String> parameters);
	
	public ACK getSerialID(java.util.Map<String,String> parameters);
	
	public ACK checkSerialID(java.util.Map<String, String> parameters);
}
