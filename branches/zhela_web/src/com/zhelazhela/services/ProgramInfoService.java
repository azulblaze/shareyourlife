package com.zhelazhela.services;

import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.domain.ProgramInfoList;

public interface ProgramInfoService {
	
	public ProgramInfo addProgramInfo(ProgramInfo programInfo,String root_path,String filetype,java.io.File logo) throws Exception;
	
	public ProgramInfo editProgramInfo(long id,String name,String shortname,String website,String email,String log,String description) throws Exception;
	
	public boolean delProgramInfo(long id,String rootpath) throws Exception;
	
	public ProgramInfo viewProgramInfo(long id) throws Exception;
	
	public ProgramInfoList loadProgramInfo(int page,int pagesize, String keywords) throws Exception;
}
