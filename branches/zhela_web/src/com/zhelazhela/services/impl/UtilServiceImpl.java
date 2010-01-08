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
import com.zhelazhela.domain.CategoryList;
import com.zhelazhela.services.UtilService;

public class UtilServiceImpl implements UtilService {
	
	private static final String location_all = "全部地区";
	
	private static final String category_all = "全部类别";
	
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
		if(StringUtils.isBlank(area)||area.indexOf(location_all)>=0){
			return new java.util.HashSet<String>();
		}
		String [] areas = area.split(",");
		Set<String> my_areas = new java.util.HashSet<String>();
		my_areas.add(location_all);
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
		if(prov_ids.size()>0){
			ProvinceExample pexample = new ProvinceExample();
			pexample.createCriteria().andIdIn(prov_ids);
			pexample.or(pexample.createCriteria().andNameIn(new java.util.ArrayList<String>(_areas)));
			List<Province> provinces = provinceDAO.selectByExample(pexample);
			for(Province province:provinces){
				my_areas.add(province.getName());
			}
		}
		return my_areas;
	}
	
	public Set<String> loadFatherAreas(String area) throws Exception {
		if(StringUtils.isBlank(area)||area.indexOf(location_all)>=0){
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
			prov_ids.add(city.getProvinceId());
		}
		if(prov_ids.size()>0){
			ProvinceExample pexample = new ProvinceExample();
			pexample.createCriteria().andIdIn(prov_ids);
			pexample.or(pexample.createCriteria().andNameIn(new java.util.ArrayList<String>(_areas)));
			List<Province> provinces = provinceDAO.selectByExample(pexample);
			for(Province province:provinces){
				my_areas.add(province.getName());
			}
		}
		return my_areas;
	}

	@Override
	public Set<String> loadCategorys(String category) throws Exception {
		if(StringUtils.isBlank(category)||category.indexOf(category_all)>=0){
			return new java.util.HashSet<String>();
		}
		String [] categorys = category.split(",");
		Set<String> my_categorys = new java.util.HashSet<String>();
		my_categorys.add(category_all);
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
			if(merchandiseCategory.getFather()>0){
				father_ids.add(merchandiseCategory.getFather());
			}
		}
		if(father_ids.size()>0){
			example.clear();
			example.createCriteria().andIdIn(father_ids);
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
	public Set<String> loadFatherCategorys(String category) throws Exception {
		if(StringUtils.isBlank(category)||category.indexOf(category_all)>=0){
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
			example.createCriteria().andIdIn(father_ids);
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
	public CategoryList loadAllCategorys(int page,int pagesize) throws Exception {
		MerchandiseCategoryExample example = new MerchandiseCategoryExample();
		if(pagesize>0){
			example.setLimit(""+(page-1)*pagesize+","+pagesize);
		}
		java.util.List<MerchandiseCategory> list = merchandiseCategoryDAO.selectByExample(example);
		int count = merchandiseCategoryDAO.countByExample(example);
		CategoryList cl = new CategoryList();
		cl.setList(list);
		cl.setPage(page);
		cl.setPagesize(pagesize);
		cl.setSize(count);
		return cl;
	}
	

	@Override
	public boolean delCategory(long id) throws Exception {
		MerchandiseCategory record = merchandiseCategoryDAO.selectByPrimaryKey(id);
		if(record!=null){
			if(record.getChild()==0){
				int result = merchandiseCategoryDAO.deleteByPrimaryKey(id);
				if(result>0){
					if(record.getFather()>0){
						MerchandiseCategory mc = merchandiseCategoryDAO.selectByPrimaryKey(record.getFather());
						if(mc!=null){
							mc.setAddTime(null);
							mc.setChild(mc.getChild()-1);
							mc.setDescription(null);
							mc.setFather(null);
							mc.setIsSystem(null);
							mc.setName(null);
							merchandiseCategoryDAO.updateByPrimaryKeySelective(mc);
						}
					}
					return true;
				}
				throw new Exception("删除失败，未知错误");
			}
			throw new Exception("该类别含有子类，您必须先删除子类才能删除它");
		}
		throw new Exception("不存在该记录");
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
		MerchandiseCategory fathermc = null;
		if(father>0){
			fathermc = merchandiseCategoryDAO.selectByPrimaryKey(father);
			if(fathermc!=null&&!fathermc.getIsSystem()){
				fathermc = null;
			}
		}
		if(father==0||fathermc!=null){
			MerchandiseCategoryExample example = new MerchandiseCategoryExample();
			example.createCriteria().andFatherEqualTo(father).andNameEqualTo(name);
			List<MerchandiseCategory> tmp = merchandiseCategoryDAO.selectByExample(example);
			if(tmp.size()==0){
				MerchandiseCategory mc = new MerchandiseCategory();
				mc.setFather(father);
				mc.setDescription(description);
				mc.setIsSystem(isSystem);
				mc.setName(name);
				long result = merchandiseCategoryDAO.insertSelectiveReturnId(mc);
				if(result>0){
					if(fathermc!=null){
						MerchandiseCategory record = new MerchandiseCategory();
						record.setId(father);
						record.setChild(fathermc.getChild()+1);
						merchandiseCategoryDAO.updateByPrimaryKeySelective(record);
					}
					return merchandiseCategoryDAO.selectByPrimaryKey(result);
				}
			}
		}
		return null;
	}

	@Override
	public long[] getLocation(String location) throws Exception {
		long []result = new long[2];
		result[0] = 0;
		result[1] = 0;
		if(location==null){
			return result;
		}
		location = location.trim();
		if(location.equals(location_all)){
			return result;
		}
		CityExample c_example = new CityExample();
		c_example.createCriteria().andNameEqualTo(location);
		List<City> citys = cityDAO.selectByExample(c_example);
		if(citys.size()>0){
			result[0] = citys.get(0).getProvinceId();
			result[1] = citys.get(0).getId();
			return result;
		}
		ProvinceExample p_example = new ProvinceExample();
		p_example.createCriteria().andNameEqualTo(location);
		List<Province> provinces = provinceDAO.selectByExample(p_example);
		if(provinces.size()>0){
			result[0] = provinces.get(0).getId();
			return result;
		}
		return result;
	}



}
