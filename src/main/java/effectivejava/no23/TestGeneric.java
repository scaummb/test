package effectivejava.no23;

import java.util.*;

/**
 * @author moubin.mo
 * @date: 2020/10/9 22:40
 */

public class TestGeneric {
	public static void main(String[] args) {
		test();
	}

	private static void testSubTyping() {
		List<String> strings = new ArrayList<String>();
//		unsafeAdd(strings, new Integer(110));
		String s = strings.get(0); // exception while run the method;
	}

	/**
	 * 方法使用了原生态类型，所以可以编译。
	 */
//	private static void unsafeAdd(List list, Object o) {
//		list.add(0);
//	}

	/**
	 * 声明了 List<Object>
	 */
	private static void unsafeAdd(List<Object> list, Object o) {
		list.add(0);
	}

	private static void test() {
		String aa = "11";
		test1(aa);
	}

	private static void test1(Object o) {
		System.out.println(o.hashCode());
	}


	private static void testInstanceOfInvalidOnGeneric(Object o) {
		if (o instanceof Set) {
			//一旦确定o是个Set，必须转换为通配符类型Set<?>，而不是原生态类型Set。这样能避免后续代码出现运行时异常。
			Set<?> set = (Set<?>) o;
		}
	}

	private static void testGenericeAfterjdk5() {
		Collection<Stamp> stamps = new ArrayList();
//		stamps.add(new Coin());//编译器告诉我们错误
	}

	/**
	 * @throws ClassCastException
	 */
	private static void testGenericeBeforejdk5() {
		Collection stamps = new ArrayList();
		stamps.add(new Coin());
		for (Iterator i = stamps.iterator(); i.hasNext(); ) {
			Stamp next = (Stamp) i.next(); //ClassCastException
		}
	}

	// 两个测试内部类
	static class Stamp {
	}

	static class Coin {
	}
}
