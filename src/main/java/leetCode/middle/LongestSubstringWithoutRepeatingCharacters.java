package leetCode.middle;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * @author moubin.mo
 * @date: 2019/11/22 12:29
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring("bbbb"));

	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int end = 0, start = 0; end < n; end++){
			char alpha = s.charAt(end);
			if (map.containsKey(alpha)){
				start = Math.max(map.get(alpha), start);
			}
			ans = Math.max(ans, end - start + 1);
			map.put(s.charAt(end), end + 1);
		}
		return ans;
	}

}
