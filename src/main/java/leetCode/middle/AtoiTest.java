package leetCode.middle;

/**
 * @author moubin.mo
 * @date: 2020/9/16 17:53
 */

public class AtoiTest {
	public static void main(String[] args) {
	}

	/**
	 * 状态机解题思路
	 */
	private static void myAtoi2(String s) {

	}

	public static int myAtoi(String str) {


		byte[] bytes = str.getBytes();

		StringBuilder result = new StringBuilder();
		// 1.空格忽略 2.-负号连接 3.数字尽可能连接 4.不可以多个负号
		int isActiveNum = 0; // 1正 2负
		int number = 0; // 0无数字 1数字拼装中
		for (int i = 0; i < bytes.length; i++) {

			// 1.空格跳过
			if (bytes[i] == 32) {
				continue;
			}

			// 1.多个负号/正号 2.非数字
			if ((number == 1 && bytes[i] == 32) || (isActiveNum != 0 && bytes[i] == 45) || (isActiveNum != 0 && bytes[i] == 43) || (bytes[i] != 45 && bytes[i] != 43 && bytes[i] != 32 && (bytes[i] < 48 || bytes[i] > 57))) {
				break;
			}

			// 1.判断正负值
			if (bytes[i] == 45) {
				isActiveNum = 2;
				continue;
			}

			if (bytes[i] == 43) {
				isActiveNum = 1;
				continue;
			}
			// 1.数组范围
			if (bytes[i] != 45 && bytes[i] != 32 && bytes[i] >= 48 && bytes[i] <= 57) {
				if (isActiveNum == 1 && !"".equals(result.toString()) && Integer.valueOf(result.toString()) > Integer.MAX_VALUE / 10) {
					return Integer.MAX_VALUE;
				} else if (isActiveNum == 2 && !"".equals(result.toString()) && Integer.valueOf(result.toString()) > Integer.MAX_VALUE / 10) {
					return Integer.MIN_VALUE;
				}
				number = 1;
				if (bytes[i] == 48 && "".equals(result.toString())) {
					continue;
				}
				result.append(new Character((char) bytes[i]));
			}
		}

		if (!"".equals(result.toString()) && !"-".equals(result.toString())) {
			if (isActiveNum == 2) {
				return Integer.valueOf("-" + result.toString());
			}
			return Integer.valueOf(result.toString());
		}
		return 0;
	}
}
