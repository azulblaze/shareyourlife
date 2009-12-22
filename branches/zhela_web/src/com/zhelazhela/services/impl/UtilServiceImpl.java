package com.zhelazhela.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.zhelazhela.db.dao.CityDAO;
import com.zhelazhela.db.dao.CountyDAO;
import com.zhelazhela.db.dao.MerchandiseCategoryDAO;
import com.zhelazhela.db.dao.ProvinceDAO;
import com.zhelazhela.db.model.City;
import com.zhelazhela.db.model.CityExample;
import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.db.model.MerchandiseCategoryExample;
import com.zhelazhela.db.model.Province;
import com.zhelazhela.db.model.ProvinceExample;
import com.zhelazhela.services.UtilService;

public class UtilServiceImpl implements UtilService {
	
	private CityDAO cityDAO;
	
	/** 目前我们不支持到小地区 **/
	private CountyDAO countyDAO;
	
	private ProvinceDAO provinceDAO;
	
	private MerchandiseCategoryDAO merchandiseCategoryDAO;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public void setCountyDAO(CountyDAO countyDAO) {
		this.countyDAO = countyDAO;
	}

	public void setProvinceDAO(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}

	public void setMerchandiseCategoryDAO(
			MerchandiseCategoryDAO merchandiseCategoryDAO) {
		this.merchandiseCategoryDAO = merchandiseCategoryDAO;
	}

	@Override
	public Set<String> loadAreas(String area) throws Exception {
		if(StringUtils.isBlank(area)){
			return new java.util.HashSet<String>();
		}
		String [] areas = area.split(",");
		Set<String> my_areas = new java.util.HashSet<String>();
		Set<String> _areas = new java.util.HashSet<String>();
		for(String tmp:areas){
			if(tmp!=null&&tmp.trim().length()>0){
				_areas.add(tmp.trim());
			}
		}
		if(_areas.size()==0){
			return my_areas;
		}
		CityExample example = new CityExample();
		example.createCriteria().andNameIn(new java.util.ArrayList<String>(_areas));
		List<City> citys = cityDAO.selectByExample(example);
		java.util.List<Long> prov_ids = new java.util.ArrayList<Long>();
		for(City city:citys){
			my_areas.add(city.getName());
			prov_ids.add(city.getProvinceId());
		}
		ProvinceExample pexample = new ProvinceExample();
		pexample.createCriteria().andIdIn(prov_ids);
		pexample.or(pexample.createCriteria().andNameIn(new java.util.ArrayList<String>(_areas)));
		List<Province> provinces = provinceDAO.selectByExample(pexample);
		for(Province province:provinces){
			my_areas.add(province.getName());
		}
		return my_areas;
	}

	@Override
	public Set<String> loadCategorys(String category) throws Exception {
		if(StringUtils.isBlank(category)){
			return new java.util.HashSet<String>();
		}
		String [] categorys = category.split(",");
		Set<String> my_categorys = new java.util.HashSet<String>();
		Set<String> _categorys = new java.util.HashSet<String>();
		for(String tmp:categorys){
			if(tmp!=null&&tmp.trim().length()>0){
				_categorys.add(tmp.trim());
			}
		}
		if(_categorys.size()==0){
			return my_categorys;
		}
		MerchandiseCategoryExample example = new MerchandiseCategoryExample();
		example.createCriteria().andNameIn(new java.util.ArrayList<String>(_categorys));
		List<MerchandiseCategory> merchandiseCategorys = merchandiseCategoryDAO.selectByExample(example);
		java.util.List<Long> father_ids = new java.util.ArrayList<Long>();
		for(MerchandiseCategory merchandiseCategory:merchandiseCategorys){
			my_categorys.add(merchandiseCategory.getName());
			if(merchandiseCategory.getFather()>0){
				father_ids.add(merchandiseCategory.getFather());
			}
		}
		if(father_ids.size()>0){
			example.clear();
			example.createCriteria().andFatherIn(father_ids);
			merchandiseCategorys = merchandiseCategoryDAO.selectByExample(example);
			father_ids.clear();
			for(MerchandiseCategory merchandiseCategory:merchandiseCategorys){
				my_categorys.add(merchandiseCategory.getName());
				if(merchandiseCategory.getFather()>0){
					father_ids.add(merchandiseCategory.getFather());
				}
			}
		}
		return my_categorys;
	}

}
