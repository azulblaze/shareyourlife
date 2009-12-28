package com.zhelazhela.services.impl;

import java.util.List;

import com.zhelazhela.db.model.MerchandiseCategory;
import com.zhelazhela.db.model.ProgramInfo;
import com.zhelazhela.db.model.Province;
import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;
import com.zhelazhela.services.ProgramInfoService;
import com.zhelazhela.services.UtilService;

public class CacheServiceImpl implements CacheService {
	
	private DiscountNewsService discountNewsService;
	
	private UtilService utilService;
	
	private ProgramInfoService programInfoService;

	private static final int ID_WEEKLYHOT = 1;
	
	private static final int ID_WEEKLYWELCOME = 2;
	
	private static final int ID_CATEGORY = 3;
	
	private static final int ID_PROGRAMINFO = 4;
		
	private static DiscountNewsList weeklyhot = null;
	
	private static DiscountNewsList weeklywelcome = null;
	
	private static List<MerchandiseCategory> categorys = null;
	
	private static List<ProgramInfo> programinfos = null;
	
	private static List<Province> provinces = null;
	
	private static long weeklyhot_time = 0l;
	
	private static long weeklywelcome_time = 0l;
	
	private static long category_time = 0l;
	
	private static long programinfo_time = 0l;
		
	private long time_between = 1000*60*10;
		
	@Override
	public DiscountNewsList loadWeeklyHot() throws Exception {
		if(weeklyhot==null){
			updateWeeklyHot();
			return weeklyhot;
		}
		if((System.currentTimeMillis()-weeklyhot_time)>=time_between){
			new Update(ID_WEEKLYHOT).start();
		}
		return weeklyhot;
	}

	@Override
	public DiscountNewsList loadWeeklyWelcome() throws Exception {
		if(weeklywelcome==null){
			updateWeeklyWelcome();
			return weeklywelcome;
		}
		if((System.currentTimeMillis()-weeklywelcome_time)>=time_between){
			new Update(ID_WEEKLYWELCOME).start();
		}
		return weeklywelcome;
	}
	

	@Override
	public List<MerchandiseCategory> loadCategory() throws Exception {
		if(categorys==null){
			updateCategorys();
			return categorys;
		}
		if((System.currentTimeMillis()-category_time)>=time_between){
			new Update(ID_CATEGORY).start();
		}
		return categorys;
	}
	@Override
	public List<ProgramInfo> loadProgram() throws Exception {
		if(programinfos==null){
			updateProgramInfo();
			return programinfos;
		}
		if((System.currentTimeMillis()-programinfo_time)>=time_between){
			new Update(ID_PROGRAMINFO).start();
		}
		return programinfos;
	}


	@Override
	public List<Province> loadProvinces() throws Exception {
		if(provinces==null){
			provinces = utilService.loadProvinces();
		}
		return provinces;
	}
	private synchronized void updateWeeklyHot(){
		weeklyhot_time = System.currentTimeMillis();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		try {
			DiscountNewsList tmp = discountNewsService.loadDiscountNewsList(1, 10, null, null, null, calendar.getTime(), "read_times desc");
			if(tmp!=null&&tmp.getSize()>0){
				weeklyhot = tmp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private synchronized void updateWeeklyWelcome(){
		weeklywelcome_time = System.currentTimeMillis();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		try {
			DiscountNewsList tmp = discountNewsService.loadDiscountNewsList(1, 10, null, null, null, calendar.getTime(), "support_times desc");
			if(tmp!=null&&tmp.getSize()>0){
				weeklywelcome = tmp;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void updateCategorys(){
		category_time = System.currentTimeMillis();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		try {
			categorys = utilService.loadCategorys(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void updateProgramInfo(){
		programinfo_time = System.currentTimeMillis();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		try {
			programinfos = programInfoService.loadProgramInfo(1, -1, null).getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class Update extends Thread{
		private int id;
		public Update(int id){
			this.id = id;
		}
		public void run(){
			switch(id){
			case ID_WEEKLYHOT:
				updateWeeklyHot();
				break;
			case ID_WEEKLYWELCOME:
				updateWeeklyWelcome();
				break;
			case ID_CATEGORY:
				updateCategorys();
				break;
			case ID_PROGRAMINFO:
				updateProgramInfo();
				break;
			default:
				break;
			}
		}
	}


	public void setDiscountNewsService(DiscountNewsService discountNewsService) {
		this.discountNewsService = discountNewsService;
	}

	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}

	public void setProgramInfoService(ProgramInfoService programInfoService) {
		this.programInfoService = programInfoService;
	}

	public long getTime_between() {
		return time_between;
	}

	public void setTime_between(long timeBetween) {
		time_between = timeBetween;
	}

}
