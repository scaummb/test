package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>kafka同步下发数据，topic的正则匹配</p>
 * @author moubin.mo
 * @date: 2020/6/16 17:19
 */

public class TestRegex {
	public static void main(String[] args) {
		String topic1 = "opc-sync-1-organization";
		String topic2 = "opc-sync-1-namespace";
		// 模式和匹配器的典型调用顺序
		// 把正则表达式编译成模式对象
		Pattern p = Pattern.compile("opc-sync.*.*organization");
		// 通过模式对象得到匹配器对象，这个时候需要的是被匹配的字符串
		Matcher m = p.matcher(topic1);
		// 调用匹配器对象的功能
		boolean b = m.matches();
		System.out.println(b);

		String a = "1234356";
		System.out.println(a.substring(a.length()-4));
	}
}
