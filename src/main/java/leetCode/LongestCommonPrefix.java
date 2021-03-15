package leetCode;

/**
 * Date: 2019/5/4 11 :08
 *
 * @author moubin.mo
 */

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		String commonPrefix = "";
		if (strs.length >= 1) {
			for (int i = 1; i <= strs[0].length(); i++) {
				// 1.prefix字段的末索引
				String prefix = strs[0].substring(0, i);
				int commonNum = 1;
				// 2.逐个元素比较是否以prefix字段开头
				for (int j = 1; j < strs.length; j++) {
					if (strs[j].startsWith(prefix)) {
						commonNum++;
					} else {
						break;
					}
				}

				// 3.所有元素都包括prefix字段则更新commonPrefix，否则退出循环并返回
				if (commonNum == strs.length) {
					commonPrefix = prefix;
				} else {
					break;
				}
			}
		}
		return commonPrefix;
	}

	public static void main(String[] args) {
//        String[] vars = {"flower","flow","flight"};
//        String[] vars = {"dog","racecar","car"};
//        String[] vars = {"mmb1","mmb111","mmb1111"};
		String[] vars = {};
		String result = longestCommonPrefix(vars);
		System.out.println("result=" + result);
	}
}
