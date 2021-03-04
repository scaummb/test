package date;

import string.utils.RemindUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2020/3/13 17:14
 */

public class TestDate {
	public static void main(String[] args) {
		test1();
	}

	private static void test2() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(1582905600000L + 57982000L));
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime());
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime() + " --- " + RemindUtils.checkRemindSpanOverOneYear(calendar.getTimeInMillis(), calendar.getTime().getTime()));
		calendar.setTime(new Date(1614845182000L));
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime() + " --- " + RemindUtils.checkRemindSpanOverOneYear(calendar.getTimeInMillis(), calendar.getTime().getTime()));
	}

	private static void test1() {
		String date = "2021-03-03";
		String substring = date.substring(0, 7);
		System.out.println(substring);
	}
}
