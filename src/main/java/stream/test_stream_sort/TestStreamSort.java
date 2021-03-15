package stream.test_stream_sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * HashSet & TreeSet
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/8 11:17
 */

public class TestStreamSort {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-DD:HH");

		Set<String> set = new HashSet();
		set.add("2021-01-08:11");
		set.add("2021-01-08:09");
		set.add("2021-01-08:08");
		set.add("2021-01-04:20");
		set.add("2021-01-05:10");
		set.add("2021-01-07:21");
		set.add("2021-01-08:07");
		set.stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				try {
					Date d1 = simpleDateFormat.parse(o1);
					Date d2 = simpleDateFormat.parse(o2);
					int i = (d1.getTime() >= d2.getTime()) ? 1 : -1;
					System.out.println("i=" + i);
					return i;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return 0;
			}
		});

		System.out.println("HashSet:");
		for (String day : set) {
			System.out.println(day);
		}

		TreeSet<String> table = new TreeSet();
		table.add("2021-01-08:11");
		table.add("2021-01-08:09");
		table.add("2021-01-08:08");
		table.add("2021-01-04:20");
		table.add("2021-01-05:10");
		table.add("2021-01-07:21");
		table.add("2021-01-08:07");
		table.stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				try {
					Date d1 = simpleDateFormat.parse(o1);
					Date d2 = simpleDateFormat.parse(o2);
					int i = (d1.getTime() >= d2.getTime()) ? 1 : -1;
					System.out.println("i=" + i);
					return i;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
		System.out.println("TreeSet:");
		for (String day : table) {
			System.out.println(day);
		}
	}
}
