package map;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/7/29 13:05
 */

public class TestMapToJson {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("key1", "fromObject");

		HashMap<String, String> map2 = new HashMap<>();
		map2.put("key1", "toObject");

		System.out.println(JSON.toJSONString(map));
		System.out.println(JSON.toJSONString(map2));
	}
}
