package leetCode;

/**
 * Date: 2019/5/20 13 :22
 *
 * @author moubin.mo
 */

public class RealizeStrStr {
	public static void main(String[] args) {
//        String haystack = "heallo";
//        String needle = "ll";
//        String haystack = "aaaaa";
//        String needle = "bba";
//        String haystack = "aaaaa";
//        String needle = "";
		String haystack = "a";
		String needle = "a";

		int index = strStr(haystack, needle);
		System.out.println("index=" + index);
	}

	public static int strStr(String haystack, String needle) {
		if ("".equals(needle)) {
			return 0;
		}

		if (needle == null || haystack == null || needle.length() > haystack.length()) {
			return -1;
		}

		// 1.两个字符串转为字符数组
		char[] chars1 = haystack.toCharArray();
		char[] chars2 = needle.toCharArray();

		// 2.遍历第一个字符数组
		for (int i = 0; i < chars1.length; i++) {
			int index = i;
			// 3.当前字符与needle字符首字符一样，且从index位置的长度未越界
			if (chars1[index] == chars2[0] && (index + chars2.length) <= chars1.length) {
				int count = 0;
				// 4.遍历第二个字符串，比较字符是否一致
				for (int j = 0; j < chars2.length; j++) {
					if (chars1[j + index] == chars2[j]) {
						count++;
					}
				}
				// 5.字符数组匹配完成返回索引位置
				if (count == chars2.length) {
					return index;
				}
			}
		}

		return -1;
	}
	//时间复杂度：O(N^2)
	//空间复杂度：O(N^2)
}
