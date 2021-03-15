package map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/8/20 09:25
 */

public class HandleMapTest {
	public static void main(String[] args) {
		HashMap<String, String> hashMap1 = new HashMap() {{
			put("1", "2");
			put("2", "2");
			put("3", "3");
			put("4", "4");
		}};
		HashMap<String, String> hashMap2 = new HashMap() {{
			put("1", "2");
			put("2", "2");
			put("3", "3");
		}};
		if (CollectionUtils.isEmpty(hashMap1) || CollectionUtils.isEmpty(hashMap2)) {
			return;
		}
		HashMap hashMap1Clone = (HashMap) hashMap1.clone();
		HashMap hashMap2Clone = (HashMap) hashMap2.clone();
		Set<String> keySet1 = hashMap1.keySet();
		keySet1.forEach(key -> {
			if (!ObjectUtils.isEmpty(hashMap2.get(key)) && hashMap1.get(key).equals(hashMap2.get(key))) {
				hashMap1Clone.remove(key);
				hashMap2Clone.remove(key);
			}
		});

		System.out.println("hashMap1Clone = " + hashMap1Clone);
		System.out.println("hashMap2Clone = " + hashMap2Clone);
	}
}
