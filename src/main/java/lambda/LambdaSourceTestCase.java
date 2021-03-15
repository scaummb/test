package lambda;

/**
 * @author moubin.mo
 * @date: 2021/1/3 23:11
 */

public class LambdaSourceTestCase {
	public static void main(String[] args) {
		String a = "a"; //定义局部变量
		MyFunction myFunction = (s) -> {
			return s;
		}; //定义匿名函数实现
		myFunction.print(a); //调用lambda
	}
}
