package textFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/8/14 12:01
 */

public class SensitiveTest {
	public static void main(String[] args) {
		FilterWordsCommand cmd = new FilterWordsCommand();
		cmd.setTextList(Arrays.asList(SensitiveConstants.CONTENT));
		Set<String> wordSet = new HashSet<>();
		String regex = "<\\s*img(.+?)src=[\"'](.*?)[\"']\\s*/?\\s*>";
		for (String text : cmd.getTextList()) {
			//匹配敏感词时，先将富文本中的链接去除 add by yanlong.liang 20190920
			try {
				text = text.replaceAll(regex, "");
				System.out.println(text);
			} catch (Exception e) {
			}
			String[] chineseWords = text.split("[a-zA-Z]+");
			String[] englishWords = text.split("[^a-zA-Z]+");
		}
	}
}
