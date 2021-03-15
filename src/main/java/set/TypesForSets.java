package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author moubin.mo
 * @date: 2020/7/5 09:43
 */

public class TypesForSets {


	static <T> Set<T> fill(Set<T> set, Class<T> type) {
		try {
			for (int i = 0; i < 10; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	static <T> void test(Set<T> set, Class<T> type) {
		fill(set, type);
		fill(set, type); // try to add duplicates
		fill(set, type);
		System.out.println(set);
	}

	public static void main(String[] args) {
		test(new HashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);
		// thins that don't work:
		test(new HashSet<SetType>(), SetType.class);


	}
}
