package list;

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2020/2/26 15:29
 */

public class TestNullList {
	public static void main(String[] args) {
		ArrayList<Long> longs = new ArrayList<>();
		ArrayList<Long> longss = null;
		longs.addAll(longss);
		for (Long a : longs){
			System.out.println(a);
		}
	}
}
