package exception;

/**
 * <p>
 * 第一次异常向上传递，随之方法执行终止，方法finally执行再到上层捕获代码段。
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/13 10:29
 */

public class ExceptionUpper {
	public static void main(String[] args) {
		try {
			test(new int[]{0, 1, 2, 3, 4, 5});
		} catch (Exception e) {
			System.out.println("E");
		}
	}

	private static void test(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			try {
				if (ints[i] % 2 == 0) {
					throw new NullPointerException();
				} else {
					System.out.println(i);
				}
			} finally {
				System.out.println("e");
			}
		}
	}
}
