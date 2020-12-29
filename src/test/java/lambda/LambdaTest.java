package lambda;

public class LambdaTest {
	public static void main(String[] args) {
		String x = "123";
		print(x, (a) -> {
			System.out.println(a);
			return a;
		});
	}

	private static String print(String x, MyFunction myFunction) {
		myFunction.print("123");
		return null;
	}

}
