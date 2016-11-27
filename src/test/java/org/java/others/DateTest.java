package org.java.others;

import java.util.Calendar;
import java.util.Date;

import org.java.util.DateUtil;
import org.junit.Test;

public class DateTest {
	/**
	 * 获得天
	 */
	@Test
	public void getDay() {
		int days = DateUtil.getDay(new Date());
		System.out.println(days);
	}

	/**
	 * 指定年月计算当月共有多少天
	 */
	@Test
	public void getDaysByYearMonth() {
		System.out.println("当前月份共有" + DateUtil.getLastDayOfMonth(2016, 7));
		System.out.println(DateUtil.getCurMonthTotalDays(2016, 7));
	}
	
	/**
	 * 指定年月计算当月共有多少天
	 */
	@Test
	public void getFirstDayDate() {
		System.out.println(DateUtil.getMonthFirstDay(new Date()));
		System.out.println(DateUtil.getFirstDayDate(new Date()));
		System.out.println(DateUtil.getMonthFirstDay("2016-01-07"));
		System.out.println(DateUtil.dateToStr(DateUtil.getDayOfWeek(DateUtil.strToDate("2016-8-24"), 2)));
		System.out.println(DateUtil.getLastDayOfMonth(new Date()));
		System.out.println(DateUtil.getMonthLastDay(new Date()));
		System.out.println(DateUtil.getMonthLastDay("2014-7-7"));
	}

}
