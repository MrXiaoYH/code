package com.zs.pms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.net.ssl.HandshakeCompletedEvent;

/**
 * 
 * @author XYH 时间工具类
 */
public class DateUtil {
	/**
	 * 获得当前时间的方法（字符串）
	 * 
	 * @return 返回当前时间字符串
	 */
	public static String getStrDate() {
		// 获得日历对象
		Calendar cal = Calendar.getInstance();
		// 获得当前的年
		int year = cal.get(Calendar.YEAR);
		// 获得当前的月(月份从0开始)
		int month = cal.get(Calendar.MONTH) + 1;
		// 获得当前的日
		int date = cal.get(Calendar.DATE);
		// 获得当前的小时
		int hour = cal.get(Calendar.HOUR_OF_DAY);
//		// 获得当前的分
//		int minute = cal.get(Calendar.MINUTE);
//		// 获得当前的秒
//		int second = cal.get(Calendar.SECOND);
//		通过获得的当前小时判断是上午，中午，下午还是晚上
		String str="";
		if (hour>=6&&hour<=11) {
			str="上午好";
		} else if(hour>11&&hour<=14){
			str="中午好";
		}else if(hour>14&&hour<=18){
			str="下午好";
		}else if(hour>18&&hour<=24){
			str="晚上好";
		}else {
			str="玩什么玩，快去睡觉";
		}
		return year + "-" + month + "-" + date + str;

	}
/**
 * 字符转Date的方法
 * @param time 字符串
 * @param pattern 输入字符串所谓时间格式
 * @return date的时间
 * @throws ParseException
 */
	public static Date getStrToDate(String time, String pattern) throws ParseException {
		// 获取格式化时间
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 返回格式化好的时间
		return sdf.parse(time);

	}
	/**
	 * Date转String时间的方法
	 * @param time Date类的时间
	 * @param pattern 把时间格式化成什么样
	 * @return 字符串类的时间
	 * @throws ParseException
	 */
	public static String getDateToStr(Date time, String pattern){
		// 获取格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 返回格式化好的时间
		return sdf.format(time);
		
	}

}
