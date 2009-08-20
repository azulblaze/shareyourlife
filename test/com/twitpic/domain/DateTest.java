package com.twitpic.domain;

import java.util.Calendar;

/**
 * <code>DateTest.java</code>
 * @version 1.0, 2009-8-20
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		System.out.println(c.getTime().toString());
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(c.getTime().toString());
		c.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(c.getTime().toString());
	}

}
