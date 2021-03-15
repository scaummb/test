package date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/1/5 20:24
 */

public class TestDateRange {
	/**
	 * DATE日期格式化
	 **/
	public final static String SIMPLE_DATE_FORMATTER = "yyyy-MM-dd";
	/**
	 * 一天毫秒数值
	 **/
	public final static Long ONE_DAY_MILLIS_TIME_COUNT = 86400000L;

	public static void main(String[] args) {
		String dateStartTime = "2020-1-1";
		String dateEndTime = "2020-1-5";
		System.out.println(getDateList(dateStartTime, dateEndTime));
	}

	public static List<String> getDateList(String dateStartTime, String dateEndTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMATTER);
		try {
			Date startDate = simpleDateFormat.parse(dateStartTime);
			Date endDate = simpleDateFormat.parse(dateEndTime);

			LocalDate start = new LocalDate(startDate.getTime());//2019-05-18 00:00:00
			LocalDate end = new LocalDate(endDate.getTime()); //2019-05-17 23:59:59
			int days = Days.daysBetween(start, end).getDays();

			System.out.println(days);
			List<String> dateStringList = new ArrayList<>(days);
			for (int day = 0; day <= days; day++) {
				String dateString = simpleDateFormat.format(new Date(startDate.getTime() + day * ONE_DAY_MILLIS_TIME_COUNT));
				dateStringList.add(dateString);
			}
			return dateStringList;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
