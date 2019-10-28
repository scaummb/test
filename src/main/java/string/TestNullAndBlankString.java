package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2019/10/19 11:21
 */

public class TestNullAndBlankString {
	public static void main(String[] args) {
		String s = "";
		Map<String, String> stringStringHashMap = new HashMap<>();
		stringStringHashMap.put(s, "11");
		stringStringHashMap.put(null, "12");
		stringStringHashMap.put(null, "13");
		System.out.println(stringStringHashMap);
	}
}
