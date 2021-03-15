package json;

import com.google.gson.Gson;

import java.util.*;

/**
 * <p>
 * json-map：{"map":{"1":"1","2":"2"},"list":["1111","2222"]}
 * </p>
 *
 * @author moubin.mo
 * @date: 2020/8/26 19:16
 */

public class JsonStringOfListOrMap {
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		ArrayList<String> list = new ArrayList<>();
		list.add("1111");
		list.add("2222");

		try {
			TestJson testJson = new TestJson(map, list);
			String jsonString = gson.toJson(testJson);
			System.out.println(jsonString);
			HashMap hashMap = (HashMap) fromJsonString(jsonString, HashMap.class);
			System.out.println(hashMap);

			Set<String> set = hashMap.keySet();
			for (String key : set) {
				Object o = hashMap.get(key);
				if (o instanceof List) {


				} else if (o instanceof Map) {


				}
				System.out.println(o.getClass());
			}
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace().toString());
		}


	}


	public static String toJsonString(Object obj) {
		return gson.toJson(obj);
	}

	public static Object fromJsonString(String jsonString, Class<?> clz) {
		return gson.fromJson(jsonString, clz);
	}

}

class TestJson {
	private Map map;
	private List list;

	public TestJson(Map map, List list) {
		this.map = map;
		this.list = list;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
}