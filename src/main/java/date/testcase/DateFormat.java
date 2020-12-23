package date.testcase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author moubin.mo
 * @date: 2020/12/21 18:21
 */

public class DateFormat {
	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:00:00");
		String format = simpleDateFormat.format(new Date(currentTimeMillis));
		System.out.println(format);

		Date date = new Date(currentTimeMillis);
		int hours = date.getHours();
		System.out.println(hours);

		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		String timeFormat = simpleDateFormat1.format(new Date());
		System.out.println(timeFormat);
		System.out.println(timeFormat.substring(0,11));

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(currentTimeMillis);
		cal.set(GregorianCalendar.HOUR, 0);
		cal.set(GregorianCalendar.MINUTE, 0);
		cal.set(GregorianCalendar.SECOND, 0);
		cal.set(GregorianCalendar.MILLISECOND, 0);
		long time1 = cal.getTimeInMillis();

		cal.add(GregorianCalendar.DAY_OF_MONTH, -1);
		long time2 = cal.getTimeInMillis();

		System.out.println("time1 = " + time1 + ", time2 = "+ time2 + ", gap = " + (time1-time2));






	}
}
