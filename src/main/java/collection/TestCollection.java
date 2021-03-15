package collection;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2019/11/3 21:22
 */

public class TestCollection {
	public static final String GATEWAY_KEY = "gateway_login";

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(11);
		String tokenString = getCacheKey(GATEWAY_KEY, "tokenString");
		System.out.println(tokenString);


	}

	private static String getCacheKey(Object... keys) {
		return StringUtils.join(Arrays.asList(keys), ":");
	}
}
