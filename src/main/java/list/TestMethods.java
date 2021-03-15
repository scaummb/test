package list;

/**
 * @author moubin.mo
 * @date: 2020/2/26 15:55
 */

public class TestMethods {
	public static void main(String[] args) {
		test1(11L);
		test2(null);

	}

	static void test1(Long a) {
		if (a != null) {
			return;
		}
		System.out.println("a is null");
	}

	static void test2(Long b) {
		if (b != null) {
			return;
		}
		System.out.println("b is null");
	}
}
