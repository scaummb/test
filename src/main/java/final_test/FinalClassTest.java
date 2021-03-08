package final_test;

/**
 * @author moubin.mo
 * @date: 2021/3/5 09:38
 */

public class FinalClassTest {
	private static String a = "a";
	public static void main(String[] args) {
		System.out.println("a.hashCode() = " + a.hashCode());
		a = "1434";
		System.out.println("a.hashCode() = " + a.hashCode());
	}
}
