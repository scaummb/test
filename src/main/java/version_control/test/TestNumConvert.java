package version_control.test;

/**
 * @author moubin.mo
 * @date: 2020/10/22 18:06
 */

public class TestNumConvert {
	public static void main(String[] args) {
		int num = 135;
		byte length = (byte) num;
		int convert = (int) length;
		System.out.println(num);
		System.out.println(length);
		System.out.println(convert);
	}
}
