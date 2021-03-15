package effectivejava.no5;

/**
 * <p>
 * jdk5之后，自动装箱使得 基本类型 & 装箱基本类型（Boxed Primitive Type）混用。
 * 两者在语义上有微妙差役，但在性能上有比较明显的差别。
 * </p>
 */

public class TestAutoBoxing {
	public static void main(String[] args) {
		testPrimitive();
		testBoxing();
	}

	private static void testBoxing() {
		long start = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println("User Boxing, sum = " + sum + ", cost : " + (System.currentTimeMillis() - start) / 1000 + "ms");
	}

	private static void testPrimitive() {
		long start = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println("User Primitive type, sum = " + sum + ", cost : " + (System.currentTimeMillis() - start) / 1000 + "ms");
	}
}
