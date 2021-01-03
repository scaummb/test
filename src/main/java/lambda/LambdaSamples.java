package lambda;

/**
 * @author moubin.mo
 * @date: 2021/1/2 11:07
 */

public class LambdaSamples {
	public static void main(String[] args) {

		//无参但是有返回值
		testNoArgButReturnVal testNoArgButReturnVal = ()->1;
		testNoArgButReturnVal testNoArgButReturnVal2 = ()->{return 1;};
		//一个参数，有返回值
		testArgWithReturnVal testArgWithReturnVal = (String a) -> {return 1;};
		testArgWithReturnVal testArgWithReturnVal2 = (a) -> {return 1;};
		testArgWithReturnVal testArgWithReturnVal3 = a -> {return 1;};
		testArgWithReturnVal testArgWithReturnVal4 = a -> 1;
		//两个参数，有返回值
		testArgsWithReturnVal testArgsWithReturnVal = (String a, Integer b) -> {return 1;};
		testArgsWithReturnVal testArgsWithReturnVal2 = (a, b) -> {return 1;};
		testArgsWithReturnVal testArgsWithReturnVal3 = (a, b) -> 1;
		//两个参数，无返回值
		testArgsWithNoReturnVal testArgsWithNoReturnVal = (String a, Integer b) -> {};
		testArgsWithNoReturnVal testArgsWithNoReturnVal2 = (String a, Integer b) -> {System.out.println("a = " + a + ", b = " + b);};
	}
	//无参但是有返回值
	@FunctionalInterface
	interface testNoArgButReturnVal {
		int testNoArgButReturnVal();
	}
	//一个参数，有返回值
	@FunctionalInterface
	interface testArgWithReturnVal {
		int testArgWithReturnVal(String message);
	}
	//两个参数，有返回值
	@FunctionalInterface
	interface testArgsWithReturnVal {
		int testArgsWithReturnVal(String message, Integer value);
	}
	//两个参数，无返回值
	@FunctionalInterface
	interface testArgsWithNoReturnVal {
		void testArgsWithNoReturnVal(String message, Integer value);
	}
}
