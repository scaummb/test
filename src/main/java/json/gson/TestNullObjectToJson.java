package json.gson;

import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/9/6 15:57
 */

public class TestNullObjectToJson {

	private static Gson gson = new Gson();

	public static void main(String[] args) {
		HashMap hashMap = null;
		String s = gson.toJson(hashMap);
		System.out.println(s);
		HashMap hashMap1 = gson.fromJson(s, HashMap.class);
		System.out.println(hashMap1);

	}
}
