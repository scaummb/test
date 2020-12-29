package date.testcase;

import date.DateHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2020/12/25 12:11
 */

public class TestDateHelper {
	private static final String FORMATSTRING = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) throws ParseException {
		String endDateStr = "2020-12-26 00:00:00";
		Date date = DateHelper.parseDataString(endDateStr, FORMATSTRING);
		System.out.println(date);


		DateFormat df = new SimpleDateFormat(FORMATSTRING);
		Date date1 = df.parse(endDateStr);
		System.out.println(date1);
	}
}
