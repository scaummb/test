/**
 * @author moubin.mo
 * @date: 2020/6/16 23:57
 */

public class Test {
	public static void main(String[] args) {
		Byte a1 = 122;
		Byte a2 = 122;
		Integer b1 = 122;
		Integer b2 = 122;
		Long c1 = 122L;
		Long c2 = 122L;

		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a2 == a1);

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1 == b2);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1 == c2);

		System.out.println(a1 == c2.byteValue());
	}
}
