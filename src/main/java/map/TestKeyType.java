package map;

import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/7/27 15:36
 */

public class TestKeyType {
	public static void main(String[] args) {
		Long key = 100L;
		HashMap integerhashMap = new HashMap<Integer, String>() {{
			put(100, "100");
		}};
		HashMap longhashMap = new HashMap<Long, String>() {{
			put(100L, "100");
		}};
		if (!ObjectUtils.isEmpty(integerhashMap.get(100))) {
			System.out.println("intmap get int: 100");
		}

		if (!ObjectUtils.isEmpty(integerhashMap.get(key.intValue()))) {
			System.out.println("intmap get long: 100");
		}

		if (!ObjectUtils.isEmpty(longhashMap.get(key.intValue()))) {
			System.out.println("longmap get int: 100");
		}

		if (!ObjectUtils.isEmpty(longhashMap.get(100L))) {
			System.out.println("longmap get long: 100");
		}


	}
}
