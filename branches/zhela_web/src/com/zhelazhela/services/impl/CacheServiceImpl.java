package com.zhelazhela.services.impl;

import com.zhelazhela.domain.DiscountNewsList;
import com.zhelazhela.services.CacheService;
import com.zhelazhela.services.DiscountNewsService;

public class CacheServiceImpl implements CacheService {
	
	private DiscountNewsService discountNewsService;

	private static final int ID_WEEKLYHOT = 1;
	
	private static final int ID_WEEKLYWELCOME = 2;
	
	private static DiscountNewsList weeklyhot = null;
	
	private static long weeklyhot_time = 0l;
	
	private static long weeklywelcome_time = 0l;
	
	private static DiscountNewsList weeklywelcome = null;
	
	private static final long time_between = 1000*60*60*3;
	
	static{
		CacheServiceImpl csi = new CacheServiceImpl();
		csi.updateWeeklyHot();
		csi.updateWeeklyWelcome();
	}
	
	@Override
	public DiscountNewsList loadWeeklyHot() throws Exception {
		if((System.currentTimeMillis()-weeklyhot_time)>=time_between){
			new Update(ID_WEEKLYHOT).start();
		}
		return weeklyhot;
	}

	@Override
	public DiscountNewsList loadWeeklyWelcome() throws Exception {
		if((System.currentTimeMillis()-weeklywelcome_time)>=time_between){
			new Update(ID_WEEKLYWELCOME).start();
		}
		return weeklywelcome;
	}
	
	public void setDiscountNewsService(DiscountNewsService discountNewsService) {
		this.discountNewsService = discountNewsService;
	}

	private synchronized void updateWeeklyHot(){
		weeklyhot_time = System.currentTimeMillis();
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(java.util.Calendar.DAY_OF_WEEK, 1);
		calendar.set(java.util.Calendar.HOUR, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		try {
			weeklyhot = discountNewsService.loadDiscountNewsList(1, 10, null, null, null, calendar.getTime(), "read_times desc");
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
			weeklywelcome = discountNewsService.loadDiscountNewsList(1, 10, null, null, null, calendar.getTime(), "support_times desc");
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
			default:
				break;
			}
		}
	}

}
