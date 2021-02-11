package string.datesort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author moubin.mo
 * @date: 2021/2/1 10:22
 */

public class TestDateSort {
	public static void main(String[] args) {
		List<String> dates = new ArrayList();
		dates.add("2021-01-25");
		dates.add("2021-02-01");
		dates.add("2021-01-31");
		dates.add("2021-01-30");
		dates.add("2021-01-28");
		dates.add("2021-01-29");
		dates.add("2021-01-26");
		dates.add("2021-01-27");

		List<String> strings = sortListKey(dates, StatisticsType.DAILY.getCode());
		System.out.println(strings);
	}

	private static List<String> sortListKey(List<String> keySet, Byte dataType) {
		switch (StatisticsType.getCode(dataType)) {
			case HOURLY:
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH");
				return keySet.stream().sorted(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						try {
							Date d1 = simpleDateFormat.parse(o1);
							Date d2 = null;
							try {
								d2 = simpleDateFormat.parse(o2);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							return (d1.getTime() > d2.getTime()) ? 1 : -1;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return 0;
					}
				}).collect(Collectors.toList());
			case DAILY:
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
				return keySet.stream().sorted(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						try {
							Date d1 = simpleDateFormat2.parse(o1);
							Date d2 = simpleDateFormat2.parse(o2);
							return (d1.getTime() > d2.getTime()) ? 1 : -1;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return 0;
					}
				}).collect(Collectors.toList());
			case MONTHLY:
				SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM");
				return keySet.stream().sorted(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						try {
							Date d1 = simpleDateFormat3.parse(o1);
							Date d2 = simpleDateFormat3.parse(o2);
							return (d1.getTime() >= d2.getTime()) ? 1 : -1;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						return 0;
					}
				}).collect(Collectors.toList());
			case DEFAULT:
			default:
		}
		return null;
	}

}
