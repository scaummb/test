package timeUtils;

import string.utils.RemindUtils;

import java.util.List;

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

//		System.out.println(RemindUtils.getNextDayStringTime("2020-01-01"));
//		String nextDayString = RemindUtils.getNextDayStringTimeOfNormalFormatter("2020-01-01" + RemindContants.FORMAT_DATE_STRING_SUFFIX);
//		System.out.println(nextDayString);
//		Timestamp endTimestamp = RemindUtils.praseFormatStringToTimeStamp(nextDayString);
//		System.out.println(endTimestamp);

		List<String> dateList = RemindUtils.getDateList("2020-01-01", "2020-01-01");
		System.out.println(dateList);
		List<String> dateListV2 = RemindUtils.getDateListV2("2020-01-01", "2020-01-01");
		System.out.println(dateListV2);

	}
}
