package packagingclass;

/**
 * @author moubin.mo
 * @date: 2019/11/1 09:05
 */

public class Test {
	public static void main(String[] args) {

		// 十进制到二进制，八进制，十六进制
		System.out.println(Integer.toBinaryString(100));
		System.out.println(Integer.toOctalString(100));
		System.out.println(Integer.toHexString(100));
		System.out.println("-------------------------");

		// 十进制到其他进制
		System.out.println(Integer.toString(100, 10));
		System.out.println(Integer.toString(100, 2));
		System.out.println(Integer.toString(100, 8));
		System.out.println(Integer.toString(100, 16));
		System.out.println(Integer.toString(100, 5));
		System.out.println(Integer.toString(100, 7));
		System.out.println(Integer.toString(100, -7));
		System.out.println(Integer.toString(100, 70));
		System.out.println(Integer.toString(100, 1));
		System.out.println(Integer.toString(100, 17));
		System.out.println(Integer.toString(100, 32));
		System.out.println(Integer.toString(100, 37));
		System.out.println(Integer.toString(100, 36));
		System.out.println("-------------------------");

		// 定义了一个int类型的包装类类型变量i
		Integer i = new Integer(100);

		Integer ii = 100;
		ii += 200;
		System.out.println("ii:" + ii);

		// 通过反编译后的代码
		Integer ii2 = Integer.valueOf(100); //自动装箱
		ii2 = Integer.valueOf(ii2.intValue() + 200); //自动拆箱， 再自动装箱
		System.out.println((new StringBuilder("ii2:")).append(ii2).toString());

//		 erException
		Integer iii = null;
		if (iii != null) {
			iii += 1000;
			System.out.println(iii);
		}


		Integer mailTestFlag = 1;
		Integer mailTestFlag2 = 0;
		if (TrueOrFalseCode.TRUE.getCode().intValue() == mailTestFlag) {
			System.out.println("************************yes************");
		}
		if (TrueOrFalseCode.TRUE.getCode().intValue() == mailTestFlag2) {
			System.out.println("************************no************");
		}
	}
}
