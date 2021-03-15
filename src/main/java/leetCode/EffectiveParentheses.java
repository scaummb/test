package leetCode;

import java.util.Stack;

/**
 * Date: 2019/5/5 14 :58
 *
 * @author moubin.mo
 */

public class EffectiveParentheses {
	public static boolean isValid(String s) {
		boolean result = false;

		// 1.判断是否有效字符串
		if (s != null && (s.length() % 2) == 0) {

			Stack<Character> stack = new Stack<Character>();

			char[] chars = s.toCharArray();

			for (int i = 0; i < s.length(); i++) {

				// 2.栈空，或栈顶元素跟当前元素不匹配，进栈
				if (stack.isEmpty() || !isMatch(stack.peek(), chars[i])) {
					stack.push(chars[i]);
				} else {
					// 3.栈顶元素跟当前元素匹配，出栈
					stack.pop();
				}
			}
			result = stack.isEmpty();
		}

		return result;
	}

	private static boolean isMatch(char a, char b) {
		switch (a) {
			case '(':
				if (b == ')') {
					return true;
				} else {
					return false;
				}
			case '{':
				if (b == '}') {
					return true;
				} else {
					return false;
				}
			case '[':
				if (b == ']') {
					return true;
				} else {
					return false;
				}
			default:
				return false;
		}
	}

	public static void main(String[] args) {
//        String var = "()";
//        String var = "()[]{}";
//        String var = "(]";
//        String var = "([)]";
		String var = "{[]}";
		boolean valid = isValid(var);
		System.out.println("result= " + valid);
	}
}
