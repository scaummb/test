package list;

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2020/1/7 15:50
 */

public class DuplicatedRemovalTest {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList(){{
			add(1);
			add(2);
			add(3);
			add(4);
		}};

		ArrayList<Integer> list2 = new ArrayList(){{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		list2.removeAll(list1);
		System.out.println(list2);
	}
}
