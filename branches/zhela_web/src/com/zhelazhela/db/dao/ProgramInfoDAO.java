package com.zhelazhela.db.dao;

import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.db.model.ProgramInfoExample;
import java.util.List;

public interface ProgramInfoDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int countByExample(ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int deleteByExample(ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	void insert(ProgramInfo record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	void insertSelective(ProgramInfo record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	List<ProgramInfo> selectByExampleWithBLOBs(ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	List<ProgramInfo> selectByExampleWithoutBLOBs(ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	ProgramInfo selectByPrimaryKey(Long id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByExampleSelective(ProgramInfo record, ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByExampleWithBLOBs(ProgramInfo record, ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByExampleWithoutBLOBs(ProgramInfo record,
			ProgramInfoExample example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByPrimaryKeySelective(ProgramInfo record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByPrimaryKeyWithBLOBs(ProgramInfo record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table program_info
	 * @ibatorgenerated  Fri Dec 18 20:52:58 CST 2009
	 */
	int updateByPrimaryKeyWithoutBLOBs(ProgramInfo record);
	
	long insertSelectiveReturnId(ProgramInfo record);
}