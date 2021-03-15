package Utils.demo;

/**
 * Date: 2019/5/30 12 :19
 *
 * @author moubin.mo
 */

public class test03 {
	public static void main(String[] args) {
		String deviceIdentify = "00af9a58cd15511669f5f3bd0f11def0d5bc44b30758f039c510107b5935945e";
		if (deviceIdentify.indexOf(":") >= 0) {
			System.out.println(111);
		} else if (deviceIdentify.length() >= 60) {
			System.out.println(222);
		}
	}
}
