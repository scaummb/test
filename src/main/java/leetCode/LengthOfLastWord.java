package leetCode;

/**
 * Date: 2019/6/9 13 :22
 *
 * @author moubin.mo
 */;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String string = "Hello World  ";
//        int length = lengthOfLastWord(string);
		int length = lengthOfLastWordV2(string);
		System.out.println("lenght=" + length);
	}

	public static int lengthOfLastWord(String s) {
		String[] split = s.split(" ");
		if (split.length <= 0) {
			return 0;
		}
		return split[split.length - 1].length();
	}

	public static int lengthOfLastWordV2(String s) {
		// 1.去掉收尾的空格符
		s = s.trim();
		int size = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}

			if (s.charAt(i) != ' ') {
				size++;
			}
		}
		return size;
	}
}
