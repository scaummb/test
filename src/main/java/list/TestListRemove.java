package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2021/1/30 23:09
 */

public class TestListRemove {
	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		int index = 0;
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();

			list.remove(index);

			index++;
		}
	}

	private static void test1() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.remove(1);
		list.remove(new Integer(3));
		list.remove(new Long(2));
		System.out.println(list);
	}
}
