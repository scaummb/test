package date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2019/8/12 22:39
 */

public class TimeStampTest {
	public static void main(String[] args) throws ParseException {
		test03();
	}

	private static void test03() {
		System.out.println("UserAuthDailyStatisticsScheduleJob, date = " + DateHelper.currentGMTTime().getTime());

		//每日统计
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println("UserAuthDailyStatisticsScheduleJob, date = " + calendar.getTimeInMillis());
	}

	private static void test02() throws ParseException {
		String date = "2019-12-17 20:10:00";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date1 = df.parse(date);
		System.out.print("compare : result = " + remindTimeIsToday(date1));
	}

	private static boolean remindTimeIsToday(Date remind) {
		return DateStatisticHelper.isSameDay(new Date(), remind);
	}

	private static void test01() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		LocalDateTime localDateTime = timeStamp.toLocalDateTime();
		System.out.println("localDateTime=" + localDateTime.getYear() + localDateTime.getMonth() + localDateTime.getDayOfMonth() + localDateTime.getMonth() + localDateTime.getHour() + localDateTime.getMinute());
		System.out.println(timeStamp.toString());


	}
}
