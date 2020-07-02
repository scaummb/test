package regex.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *     1 输入：abcabcabcabcabcabc "abc+" "(abc)+" "(abc){2,}"
 *     2 Pattern 表示编译后的正则表达式
 *     3 使用已编译的Pattern对象的matcher()方法，加上一个输入字符串，从而共同构造了一个Matcher对象
 *     4 Pattern提供了static方法：以检查regex是否匹配整个CharSequence类型的Input参数。
 *
 * </p>
 * @author moubin.mo
 * @date: 2020/7/3 00:29
 */

public class TestRegularExpression {
	public static void main(String[] args) {
		if (args.length < 2){
			System.out.println("Usage: \n java TestRegularExpression characterSequence regularExpression.");
			System.exit(0);
		}

		System.out.println("Input: " + args[0]);

		for (String arg : args){
			System.out.println("Regular expression : " + arg);
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find()){
				System.out.println("Match " + m.group() + " at positions " + m.start() + " - " + (m.end() - 1));
			}
		}
	}
}
