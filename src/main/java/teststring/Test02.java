package teststring;

/**
 * <p>
 *     JVM的内存模型了解吗，比如我new一个String对象，它被存在哪，static String呢？final String呢？
 * </p>
 */

public class Test02 {
	private final static String a = "123";
	private final static String b = "123"; //引用不可以被重新赋值
	public static void main(String[] args) {
		//'new String' is redundant 多余的。
		String s = new String("123");
		System.out.println(s.hashCode());
		s = " 123 ";
		System.out.println(s.hashCode());
		s = " 123 ";
		System.out.println(s.hashCode());
		s = new String("123");
		System.out.println(s.hashCode());
		System.out.println(a.hashCode());
	}
}
