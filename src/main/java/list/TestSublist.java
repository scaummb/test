package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2019/8/29 16:49
 */

public class TestSublist {
	public static void main(String[] args){
		ArrayList<Long> list = new ArrayList<>();
		list.add(1000L);
		list.add(1001L);
		list.add(1002L);
		list.add(1003L);
		list.add(1004L);
		list.add(1005L);
		list.add(1006L);
		List<Long> list2 = list.subList(0, list.size()-1); // 0：第0个元素开始；6：第6个元素截止
		List<Long> list3 = list.subList(list.size()-1, list.size()); // 6：第6个元素开始；7：第7个元素截止
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
	}

}
