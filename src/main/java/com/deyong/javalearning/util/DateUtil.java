package com.deyong.javalearning.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间、日期工具类
 * @author tong deyong
 *
 */
public final class DateUtil {
	
	/** yyyy-MM-dd */
	public static String YYYY_MM_DD = "yyyy-MM-dd";
	/** HH:mm:ss */
	public static String HH_MM_SS = "HH:mm:ss";
	/** yyyy-MM-dd HH:mm:ss */
	public static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	/**
	 * 有意構造
	 */
		private DateUtil() {}
		
		/**
		 * 获取yyyyMMddHHmmss格式时间
		 * @return yyyyMMddHHmmss 时间字符串
		 */
		public static String getDateTimeStr() {
			return new SimpleDateFormat(YYYYMMDDHHMMSSSSS).format(new Date());
		}
		
		/**
		 * 获取当前时间
		 * @return 当前时间字符串“HH:mm:ss”
		 */
		public static String getNowTimeStr() {
			return getDateStr(HH_MM_SS);
		}
		
		/**
		 * 获取当前日期
		 * @return 现在日期字符串“yyyy-MM-dd”
		 */
		public static String getNowDateStr() {
			return getDateStr(YYYY_MM_DD);
		}
		
		/**
		 * 根据时间格式获取时间
		 * @param format 时间格式
		 * @return 指定格式字符串
		 */
		public static String getDateStr(String format) {
			return new SimpleDateFormat(format).format(new Date());
		}
}
