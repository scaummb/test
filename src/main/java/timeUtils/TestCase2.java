package timeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Date / LocalDateTime
 * SimpleDateFormat / DateTimeFormatter
 * @author moubin.mo
 * @date: 2019/12/23 13:03
 */

public class TestCase2 {

	public static void main(String[] args) {
		createLocalDateTime();
	}

	private static Date createDate() throws ParseException {
		Date date = new Date(2019, 12, 23);
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat();
		SimpleDateFormat.parse("yyyy--MM-dd");
		return date;
	}

	private static Calendar createCalendar(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 12, 23);
		return calendar;
	}

	private static LocalDateTime createLocalDateTime() {
//		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(2019, Month.DECEMBER, 23, 14, 45, 11);
		// 日期修改
		localDateTime = localDateTime.minusYears(2);
		localDateTime = localDateTime.minusHours(2);
		localDateTime = localDateTime.plusMonths(3);

		// 天数增加/减少
//		localDateTime = localDateTime.plusDays(1);
//		localDateTime = localDateTime.plusDays(-1);
		localDateTime = localDateTime.plus(-11, ChronoUnit.DAYS);
		System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

		// 格式化日期
		String result1 = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		String result2 = localDateTime.format(DateTimeFormatter.ISO_DATE);
		String result3 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		String result4 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy--MM--dd"));
		String result5 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-00-MM-00-dd"));
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);

		return localDateTime;
	}
}
