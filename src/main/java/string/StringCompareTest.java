package string;

import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2020/1/8 14:33
 */

public class StringCompareTest {
	public static void main(String[] args) {
		String date1 = "2019-01-01";
		String date2 = "2019-01-01";
		String END_PREFIX = " 00:00:00";
//		List<String> dateList = RemindUtils.getDateList(date1, date2);
		Timestamp timestamp1 = Timestamp.valueOf(date1 + END_PREFIX);
		Timestamp timestamp2 = Timestamp.valueOf(date2 + END_PREFIX);
		if (timestamp1.equals(timestamp2)){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}
}
