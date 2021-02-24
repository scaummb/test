package nullcase.case3;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author moubin.mo
 * @date: 2020/9/14 21:36
 */

public class TestHashMapNull {
	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");

	}

	private static void test1() {
		HashSet<Long> userIdSet = new HashSet<>();
		String join = StringUtils.join(userIdSet, ",");
		System.out.println(join);
	}
}
