package string.utils;


import ch.hsr.geohash.GeoHash;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日程工具类
 * @author moubin.mo
 * @date: 2020/1/4 14:21
 */

public class RemindUtils {

	/**
	 * 返回实际时间的格式化的日期时间(yyyy-MM-dd)
	 */
	public static String getCurrentLocalTimeDate(){
		return LocalDateTime.now().format(RemindContants.DEFAULT_LOCAL_DATE_TIME_FORMATTER);
	}

	/**
	 * 根据时间戳返回格式化的日期时间(yyyy-MM-dd)
	 */
	public static String getChosedRemindStartDate(Long planDate) {
		Date date = new Date(planDate);
		SimpleDateFormat sdf = new SimpleDateFormat(RemindContants.SIMPLE_DATE_FORMATTER);
		return sdf.format(date);
	}

	/**
	 * 系统时间是否在以 planStartTime 为开始时间戳的一天区间内
	 * @param planStartTime
	 * @param systemCurrentTimeMillis
	 * @return 比较结果（Boolean）
	 */
	public static boolean isToday(Long planStartTime, long systemCurrentTimeMillis) {
		return ((systemCurrentTimeMillis >= planStartTime)
				&& (systemCurrentTimeMillis <= (planStartTime+RemindContants.ONE_DAY_MILLIS_TIME_COUNT)));
	}

	/**
	 * 生成 GeoHash
	 * @param longitude
	 * @param latitude
	 * @return GeoHash
	 */
	public static String createGeoHash(Double longitude, Double latitude, Integer geoCharCount) {
		if (longitude == null || latitude == null
				||Double.isNaN(longitude) || Double.isNaN(latitude)){
			return null;
		}
		GeoHash geo = GeoHash.withCharacterPrecision(latitude, longitude, geoCharCount);
		return geo.toBase32();
	}

	/**
	 * 获取两个日期间的全部日期列表
	 * @param dateStartTime
	 * @param dateEndTime
	 * @return List<String> {2020-01-01, 2020-01-02, 2020-01-03, 2020-01-04, 2020-01-05}
	 */
	public static List<String> getDateList(String dateStartTime, String dateEndTime) {
		List<String> dateStringList = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RemindContants.SIMPLE_DATE_FORMATTER);
		try {
			Date startDate = simpleDateFormat.parse(dateStartTime);
			Date endDate = simpleDateFormat.parse(dateEndTime);
			LocalDate start = new LocalDate(startDate.getTime());
			LocalDate end = new LocalDate(endDate.getTime());
			int days = Days.daysBetween(start, end).getDays();
			for (int day=0; day<=days; day++){
				String dateString = simpleDateFormat.format(new Date(startDate.getTime() + day * RemindContants.ONE_DAY_MILLIS_TIME_COUNT));
				dateStringList.add(dateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStringList;
	}

	/**
	 * 获取两个日期间的全部日期数量
	 * @param dateStartTime
	 * @param dateEndTime
	 * @return 包含开始结束日期的日期数
	 */
	public static Integer getDayCount(String dateStartTime, String dateEndTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RemindContants.SIMPLE_DATE_FORMATTER);
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = simpleDateFormat.parse(dateStartTime);
			endDate = simpleDateFormat.parse(dateEndTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LocalDate start = new LocalDate(startDate.getTime());
		LocalDate end = new LocalDate(endDate.getTime());
		Integer days = Days.daysBetween(start, end).getDays();
		return Integer.sum(days, 1);
	}

	/**
	 * 转换为格式化日期字符串
	 * @param planDate
	 * @return dateTimeString（格式化日期字符串：yyyy-MM-dd）
	 */
	public static String praseTimeStamp(Timestamp planDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RemindContants.SIMPLE_DATE_FORMATTER);
		return simpleDateFormat.format(planDate);
	}

	/**
	 * 转换为格式化日期字符串
	 * @param planDate
	 * @return dateTimeString（格式化日期字符串：yyyy-MM-dd）
	 */
	public static Timestamp praseFormatStringToTimeStamp(String planDate) {
		return Timestamp.valueOf(planDate);
	}

	/**
	 * 根据日期获取下一天的日期字符串 {yyyy-MM-dd}
	 * @param dateEndTime
	 * @return  下一天的日期字符串{yyyy-MM-dd}
	 */
	public static String getNextDayStringTime(String dateEndTime) {
		SimpleDateFormat sdf = new SimpleDateFormat(RemindContants.SIMPLE_DATE_FORMATTER);
		Boolean isLegal = false;
		try {
			Date endDate = sdf.parse(dateEndTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(endDate);
			calendar.add(Calendar.DATE, 1);
			return sdf.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateEndTime;
	}
}
