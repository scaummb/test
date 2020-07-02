package list.testsublist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> 测试用例：ArrayList.subList</p>
 * @author moubin.mo
 * @date: 2020/6/23 11:36
 */

public class TestSublist {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
//		a.add(11);
//		a.add(12);
//		a.add(13);
//		a.add(131);
//		a.add(132);
//		a.add(133);

//		System.out.println(Arrays.toString(a.toArray()));
//		System.out.println(Arrays.toString(b.toArray()));
//		System.out.println(Arrays.toString(c.toArray()));

		int size = 3;
		for (int round = 0; round <= (a.size()/size); round++) {
			int endAnchor = (a.size() <=  (round+1)*size)? a.size(): (round+1)*size;
			List<Integer> subList = a.subList(round * size, endAnchor);
			System.out.println(Arrays.toString(subList.toArray()));
		}


	}
}
