package lambda;

/**
 * @author moubin.mo
 * @date: 2020/12/15 18:17
 */

public class LambdaTest {
	public static void main(String[] args) {
		//method invoke
		String x = "123";
		//正常操作=调用方法的声明
		//lambda=调用时定义好方法体（声明+实现）
		print(x, (a) -> {
			System.out.println("321");
			return a;
		});
	}

	private static String print(String x, MyFunction myFunction) {
		//正常操作=实现体不需要再调用方法
		//lambda=在调用+传参
		//method invoke
		System.out.println(x + myFunction.print("123"));
		return null;
	}

	//声明方法
	private void test(){
		//实现方法体
	}
}
