package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 简单递归排序算法：使用了大量的额外内存。
 * </p>
 *
 * @author moubin.mo
 * @date: 2020/10/20 23:22
 */

public class SimpleRecursiveSort {
	public static void sort(List<Integer> items) {
		if (items.size() > 1) {
			ArrayList<Integer> smaller = new ArrayList<>();
			ArrayList<Integer> same = new ArrayList<>();
			ArrayList<Integer> bigger = new ArrayList<>();

			Integer chosenItem = items.get(items.size() / 2);

			for (Integer i : items) {
				if (i < chosenItem) {
					smaller.add(i);
				} else if (i > chosenItem) {
					bigger.add(i);
				} else {
					same.add(i);
				}
			}

			sort(smaller);
			sort(bigger);

			items.clear();
			items.addAll(smaller);
			items.addAll(same);
			items.addAll(bigger);
		}
	}
}
