package lambda;

/**
 * @author moubin.mo
 * @date: 2020/12/15 18:17
 */

public class LambdaTest {
	public static void main(String[] args) {
		//lambda：调用时定义好方法体（声明+实现）
		print("1233333", a -> a);
	}

	//lambda：可作为方法参数传递
	private static String print(String x, MyFunction myFunction) {
		myFunction.print(x);
		return null;
	}

}
