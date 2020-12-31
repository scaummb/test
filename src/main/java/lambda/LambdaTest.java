package lambda;

/**
 * @author moubin.mo
 * @date: 2020/12/15 18:17
 */

public class LambdaTest {
	public static void main(String[] args) {
		//method invoke
		String x = "1233333";
		//正常操作=调用方法的声明
		//lambda=调用时定义好方法体（声明+实现）
		print(x, (a) -> {
			System.out.println(a);
			return a;
		});
	}

	private static String print(String x, MyFunction myFunction) {
		//method invoke
		myFunction.print(x);
		return null;
	}

}
