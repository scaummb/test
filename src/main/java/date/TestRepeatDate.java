package date;

import java.util.Calendar;

/**
 * @author moubin.mo
 * @date: 2020/3/13 10:10
 */

public class TestRepeatDate {
	public static void main(String[] args) {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DATE, 13);
		System.out.println(instance.getTimeInMillis());

//		Calendar calendar = Calendar.getInstance();
//		Long current = 1584028800000L;
//		Long currentEnd = 1584065484000L;
//		Long timeSplan = currentEnd - current;
//		calendar.add(Calendar.YEAR, 1);
//		Date time = calendar.getTime();
//
//		calendar.setTime(new Date(current));
//
//		System.out.println(calendar.get(Calendar.DATE));
//		calendar.set(Calendar.DATE, 1);
//		System.out.println(calendar.get(Calendar.DATE));



//		ArrayList<RemindDate> list = new ArrayList<>();
//		do {
//			list.add(new RemindDate(new Timestamp(current), new Timestamp(currentEnd)));
//			// 当前月的日期
//			int date = calendar.get(Calendar.DATE);
//			calendar.add(Calendar.MONTH, 1);
//			// 如果下个月不存在相同日期
//			if (date >= calendar.getActualMaximum(Calendar.DATE)){
//				calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//				list.add(new RemindDate(new Timestamp(calendar.getTime().getTime()), new Timestamp(calendar.getTime().getTime() + timeSplan)));
//			} else {
//				// 下个月存在相同日期
//				calendar.set(Calendar.DATE, date);
//				list.add(new RemindDate(new Timestamp(calendar.getTime().getTime()), new Timestamp(calendar.getTime().getTime() + timeSplan)));
//			}
//		} while (current <= time.getTime());
//
//		System.out.println(list);
	}
}
