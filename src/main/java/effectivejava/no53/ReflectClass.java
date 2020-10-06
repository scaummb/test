package effectivejava.no53;

import java.util.Arrays;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/10/1 09:55
 */

public class ReflectClass {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found.");
			System.exit(1);
		}

		Set<String> s = null;
		try {
			s = (Set<String>) c1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}
}
