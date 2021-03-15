package effectivejava.no41;

import java.util.*;

/**
 * <p>
 * overloaded，需要调用哪个重载方法是在编译时做出的觉得。对于三个重载方法，他们的参数编译时类型(类型擦除)都是一样的:Collection<?> s
 * 重载(overloaded method)区别于覆盖方法(overridden method)：
 * 重载方法选择是静态的，覆盖方法选择是动态的。（被覆盖的方法是在运行时决定，依据是被调用方法所在对象的运行时类型）
 * </p>
 *
 * @author moubin.mo
 * @date: 2020/9/26 23:06
 */

public class CollectionClassifier {
	//重载1
	public static String classify(Set<?> s) {
		return "set";
	}

	//重载2
	public static String classify(List<?> s) {
		return "list";
	}

	//重载3
	public static String classify(Collection<?> s) {
		return "Unknown Collection";
	}

	public static void main(String[] args) {
		Collection<?>[] collections = {
				new HashSet<String>(),
				new ArrayList<String>(),
				new HashMap<String, String>().values(),
		};
		for (Collection<?> c : collections) {
			System.out.println(classify(c));
		}
	}
}
