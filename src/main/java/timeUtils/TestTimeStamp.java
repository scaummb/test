package timeUtils;

import string.utils.RemindUtils;

/**
 * @author moubin.mo
 * @date: 2020/1/13 21:29
 */

public class TestTimeStamp {
	public static void main(String[] args) {
//		Timestamp timeStamp = RemindUtils.praseFormatStringToTimeStamp("2020-01-01" + RemindContants.FORMAT_DATE_STRING_SUFFIX);
//		Timestamp timestamp = new Timestamp(RemindUtils.praseFormatStringToTimeStamp("2020-01-01" + RemindContants.FORMAT_DATE_STRING_SUFFIX).getTime());
//		System.out.println(timeStamp);
//		System.out.println(timestamp);

		System.out.println(RemindUtils.getNextDayStringTime("2020-01-01"));


	}
}
