package com.zlcd.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class DateUtils {
	/** yyMMdd */
	public final static String Y2M2D2 = "yyMMdd";
	/** yyMM */
	public final static String Y4M2 = "yyyyMM";
	/** yyyyMMdd */
	public final static String Y4M2D2 = "yyyyMMdd";
	/** yyyy-MM-dd */
	public final static String Y4M2D2WithSeprate = "yyyy-MM-dd";
	/** yyyyMMddHHmmssSSS */
	public final static String Y4M2D2HMSL = "yyyyMMddHHmmssSSS";
	/** yyMMddHHmmssSSS */
	public final static String Y2M2D2HMSL = "yyMMddHHmmssSSS";
	/** yyyyMMddHHmmss */
	public final static String Y4M2D2HMS = "yyyyMMddHHmmss";
	/** HHmmssSSS */
	public final static String HHmmssSSS = "HHmmssSSS";
	/** HHmmss */
	public final static String HHmmss = "HHmmss";
	/** HH:mm:ss */
	public final static String HHmmssWithSeprate = "HH:mm:ss";
	/** yyyy-MM-dd HH:mm:ss */
	public final static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	/** yyyy/MM/dd HH:mm:ss */
	public final static String dateTimePattern2 = "yyyy/MM/dd HH:mm:ss";

	/**
	 * @return 201411
	 */
	public static String getSysDateY4M2() {
		return getDateTime(new Date(), Y4M2);
	}
	/**
	 * @return 2014-11-12
	 */
	public static String getSysDateY4M2D2WithSeprate() {
		return getDateTime(new Date(), Y4M2D2WithSeprate);
	}
	/**
	 * @return 20141118
	 */
	public static String getSysDateY4M2D2() {
		return getDateTime(new Date(), Y4M2D2);
	}

	/**
	 * @return 110701
	 */
	public static String getSysTime() {
		return getDateTime(new Date(), HHmmss);
	}

	/**
	 * @return yyyyMMddHHmmssSSS
	 */
	public static String getSysDateTime() {
		return getDateTime(new Date(), Y4M2D2HMSL);
	}


	/**
	 * @param strDate
	 *            yyyy-MM-dd
	 * @return
	 */
	public static Long getStartTime(String strDate) {
		if (StringUtils.isBlank(strDate))
			return null;
		return Timestamp.valueOf(strDate.trim() + " 00:00:00").getTime();
	}

	/**
	 * @param strDate
	 * @return
	 */
	public static Long getEndTime(String strDate) {
		if (StringUtils.isBlank(strDate))
			return null;
		return Timestamp.valueOf(strDate.trim() + " 24:00:00").getTime() - 1;
	}

	/**
	 * @param date
	 * @param pattern
	 */
	public static String getDateTime(Date date, String pattern) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (date != null) {
			df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}

		return returnValue;
	}

	/**
	 * @param date
	 * @param pattern
	 */
	public static String getDateTime(Long date, String pattern) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (date != null) {
			df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}

		return returnValue;
	}

	/**
	 * @param y4M2D2
	 */
	public static String toY4M2D2WithSeprate(String y4M2D2) {
		if (y4M2D2 == null) {
			return null;
		}
		if (y4M2D2.length() == 8) {
			String year = y4M2D2.substring(0, 4);
			String month = y4M2D2.substring(4, 6);
			String day = y4M2D2.substring(6, 8);
			return year.concat("-").concat(month).concat("-").concat(day).toString();
		}
		return y4M2D2;
	}

	/**
	 * @param source
	 * @param pattern
	 */
	public static Date parse(String source, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {

		}
		return date;
	}

	public static String convert(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String str = sdf.format(date);
		return str;
	}

	public static String getLastMonthFirstDate(String pattern) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set((cal.get(Calendar.YEAR)), cal.get(Calendar.MONTH), 1);
		return convert(cal.getTime(), pattern);
	}

	public static String getLastMonthLastDate(String pattern) {
		Calendar cal = Calendar.getInstance();
		cal.set((cal.get(Calendar.YEAR)), cal.get(Calendar.MONTH), 1);
		cal.add(Calendar.DATE, -1);
		return convert(cal.getTime(), pattern);
	}

	public static Long combineDate(String date, String time) {
		String dateTimeStr = date + " " + time;
		if (dateTimeStr.length() == 16) {
			dateTimeStr = dateTimeStr + ":00";
		}
		return Timestamp.valueOf(dateTimeStr).getTime();
	}

	public static Long getTimeByPattern(String dateTime, String pattern) {
		Date date = parse(dateTime, pattern);
		return date.getTime();
	}

	public static void main(String[] args) {
	}

	public static Long getChangeTime(int year,int month,int day){
		Calendar cal  = Calendar.getInstance();
		if(year!=0){
			cal.add(Calendar.YEAR, year);
		}
		if(month!=0){
			cal.add(Calendar.MONTH, month);
		}
		if(day!=0){
			cal.add(Calendar.DATE, day);
		}
		return cal.getTime().getTime();
	}
	

	public static Long getChangeMonth(int year,int month,Long time){
		Calendar cal  = Calendar.getInstance();
		Date d = new Date();
		d.setTime(Timestamp.valueOf(DateUtils.getDateTime(time, "yyyy-MM-01 00:00:00")).getTime());
		cal.setTime(d);
		if(year!=0){
			cal.add(Calendar.YEAR, year);
		}
		if(month!=0){
			cal.add(Calendar.MONTH, month);
		}
		return cal.getTime().getTime();
	}

	public static int getDaysByYearMonth(int year, int month) {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
}
