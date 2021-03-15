package array.arrays;

/**
 * @author moubin.mo
 * @date: 2021/2/27 15:39
 */

public class TestArray02 {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		char[] a = new char[10];
		System.out.println(a.length);
		testfor('a', a);
	}

	private static void testfor(char a, char[] a1) {
		for (int k = 0; k < a1.length; k++) {
			if (a == a1[k]) {
				System.out.println("yes");
			} else {
				System.out.println("yes");
			}
		}
	}
}
