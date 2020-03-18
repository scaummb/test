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
//		1584086782000L;	2020-03-13 16:06:22
//		1584028800000L;	2020-03-13 00:00:00
//		57982000L; splan
//		1586707200000L;2020-04-13 00:00:00
//		1588089600000L;2020-04-29 00:00:00
//		System.out.println(new Date(1584028800000L + 57982000L));
//		System.out.println(RemindUtils.checkRemindSpanOverOneYear(1584028800000L, 57982000L,1585411200000L));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(1582905600000L + 57982000L));
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime());

		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime() + " --- " + RemindUtils.checkRemindSpanOverOneYear(calendar.getTimeInMillis(), calendar.getTime().getTime()));

		calendar.setTime(new Date(1614845182000L));
		System.out.println(calendar.getTime() + " " + calendar.getTime().getTime() + " --- " + RemindUtils.checkRemindSpanOverOneYear(calendar.getTimeInMillis(), calendar.getTime().getTime()));

//		System.out.println(calendar.getTimeInMillis() + "---" + calendar.getTime() + "----" + planEndDate);
//		return (Long.compare(calendar.getTimeInMillis(), (planEndDate)) >= 0);
	}
}
