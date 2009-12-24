package com.zhelazhela.services.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.zhelazhela.db.dao.CityDAO;
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
	
	private ProvinceDAO provinceDAO;
	
	private MerchandiseCategoryDAO merchandiseCategoryDAO;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
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
	
	@Override
	public MerchandiseCategory loadCategory(long id) throws Exception {
		return merchandiseCategoryDAO.selectByPrimaryKey(id);
	}

	@Override
	public List<MerchandiseCategory> loadCategorys(long father) throws Exception{
		MerchandiseCategoryExample example = new MerchandiseCategoryExample();
		example.createCriteria().andFatherEqualTo(father).andIsSystemEqualTo(true);
		return merchandiseCategoryDAO.selectByExample(example);
	}

	@Override
	public List<MerchandiseCategory> loadAllCategorys(int page,int pagesize) throws Exception {
		MerchandiseCategoryExample example = new MerchandiseCategoryExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		return merchandiseCategoryDAO.selectByExample(example);
	}
	
	@Override
	public List<City> loadCitys(long provinceId) throws Exception{
		CityExample example = new CityExample();
		example.createCriteria().andProvinceIdEqualTo(provinceId);
		return cityDAO.selectByExample(example);
	}

	@Override
	public List<Province> loadProvinces()throws Exception {
		ProvinceExample example = new ProvinceExample();
		return provinceDAO.selectByExample(example);
	}

	@Override
	public MerchandiseCategory addCategory(long father, boolean isSystem,
			String name, String description)throws Exception {
		MerchandiseCategoryExample example = new MerchandiseCategoryExample();
		example.createCriteria().andIdEqualTo(father).andIsSystemEqualTo(true);
		List<MerchandiseCategory> tmp = merchandiseCategoryDAO.selectByExample(example);
		if(tmp.size()>0){
			example.clear();
			example.createCriteria().andFatherEqualTo(father).andNameEqualTo(name);
			tmp = merchandiseCategoryDAO.selectByExample(example);
			if(tmp.size()==0){
				MerchandiseCategory mc = new MerchandiseCategory();
				mc.setFather(father);
				mc.setDescription(description);
				mc.setIsSystem(isSystem);
				mc.setName(name);
				long result = merchandiseCategoryDAO.insertSelectiveReturnId(mc);
				if(result>0){
					return merchandiseCategoryDAO.selectByPrimaryKey(result);
				}
			}
		}
		return null;
	}


}
