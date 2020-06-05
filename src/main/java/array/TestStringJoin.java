package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/6/2 16:50
 */

public class TestStringJoin {
	public static void main(String[] args) {
		List<String> followerContactNames = new ArrayList(){{add("1");add("2");add("3");}};
		String followUpUsersNameList = String.join(",", followerContactNames);
		System.out.println(followUpUsersNameList);
	}
}
