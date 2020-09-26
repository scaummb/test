package effectivejava.no41;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author moubin.mo
 * @date: 2020/9/26 23:26
 */

public class SetList {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = -3; i < 3; i++){
			set.add(i);
			list.add(i);
		}
		System.out.println(set);
		System.out.println(list);

		for (int i = 0; i<3; i++){
			set.remove(i); //i:object to be removed from this set, if present
			list.remove(i); // i:the index of the element to be removed，每次操作，底层数组的元素下标都会变化
		}
		System.out.println(set + " " + list);
	}
}
