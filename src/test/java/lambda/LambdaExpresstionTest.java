package lambda;

public class LambdaExpresstionTest {
	public static void main(String[] args) {
		String x = "123444";
		print(x, (a) -> {
			System.out.println("lambda实现1..."+ a);
			return a;
		});
		print(x, (a) -> {
			System.out.println("lambda实现2...");
			return a;
		});
	}

	private static String print(String x, MyFunction myFunction) {
		myFunction.print(x);
		return null;
	}

}
