package anchor;

/**
 * @author moubin.mo
 * @date: 2019/11/11 12:05
 */

public class TestAnchor {
	public static void main(String[] args) {
		long a1 = 1573445075378L / 86400000; //2019-11-11 12:04:35
		long a2 = 1573481075000L / 86400000; //2019-11-11 22:04:35
		long a3 = 1573394675000L / 86400000; //2019-11-10 22:04:35
		long a4 = 1573358675000L / 86400000; //2019-11-10 12:04:35
		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		System.out.println("a3 = " + a3);
		System.out.println("a4 = " + a4);


	}
}
