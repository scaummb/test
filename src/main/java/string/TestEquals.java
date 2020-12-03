package string;

/**
 * @author moubin.mo
 * @date: 2019/9/15 15:23
 */

public class TestEquals {

	private static void testInit() {
		//两种
		String a = "ab";
		String b = "a" + "b";
		System.out.println("(a == b) = " + (a == b)); //内存首地址，比较a 和 b 是同一个对象
		System.out.println("(a.equals(b)) = " + (a.equals(b))); // Stirng的覆盖实现方法equals方法,比较 a 和 b 的内容值

		//内存首地址(new出来是堆里面的对象地址，直接赋值用的是常量池的地址), 比较a 和 c 不是同一个对象
		String c = new String("ab");
		System.out.println("(a == c) = " + (a == c));
	}
}
