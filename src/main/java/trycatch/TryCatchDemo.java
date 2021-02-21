package trycatch;

/**
 * <p>
 *     try 的 return 不会生效
 *     finally 块一定会执行
 * </p>
 * @author moubin.mo
 * @date: 2021/2/19 23:06
 */

public class TryCatchDemo {
	public static void main(String[] args) {
		int b = 10;
		System.out.println(test(b));
	}
	public static int test(int b){
		try {
			b += 10;
			return b;
		} catch (RuntimeException ex){

		} catch (Exception ex){

		}finally {
			b += 10;
			return b;
		}
	}
}
