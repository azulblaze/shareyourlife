package com.zhelazhela.cloudblog.services;

import com.zhelazhela.cloudblog.domain.ACK;

public interface Maintenance {

	/**
	 * domain.com/dev/test
	 * GET
	 * @param parameters
	 * @return
	 */
	public ACK testNetwork(java.util.Map<String,String> parameters);
	
}
