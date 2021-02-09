package date.testcase;

import date.DateStatisticHelper;

import java.text.ParseException;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2021/1/26 15:02
 */

public class TestMonthDate {
	public static void main(String[] args) throws ParseException {
		String startDate = "2020-12-01 00:00:00";
		String endDate = "2021-01-26 23:59:59";
		Date monthStartDateTime = DateStatisticHelper.getMonthStartDateTime(startDate);
		Date monthEndDateTime = DateStatisticHelper.getMonthEndDateTime(endDate);
		System.out.println(monthStartDateTime);
		System.out.println(monthEndDateTime);
	}
}
