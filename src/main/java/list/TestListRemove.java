package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2021/1/30 23:09
 */

public class TestListRemove {
	public static void main(String[] args) {
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
