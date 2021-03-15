package array.arrays;

/**
 * <p>
 * 强制类型转换，不会四舍五入的！！
 * 运算会逐渐升级。
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/2/27 16:01
 */
public class TestDeliver {
	public static void main(String[] args) {
		int a1 = 10 / 2;
		int a2 = (int) (10.5 / 2);
		int a3 = (int) (10 / 2.5);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		int a4 = (int) (10.9 / 2);
		System.out.println(a4);
		System.out.println((int) 10.9);
	}
}
