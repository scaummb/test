package string.length;

/**
 * @author moubin.mo
 * @date: 2020/7/29 10:42
 */

public class TestStringBytesLength {
	public static void main(String[] args) {
		String a = "aa";
		System.out.println(getLength(a));
	}

	public static int getLength(String s) {
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int ascii = Character.codePointAt(s, i);
			if (ascii >= 0 && ascii <= 255) {
				length++;
			} else {
				length += 2;
			}
		}
		return length;
	}
}
