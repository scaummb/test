package regex.replace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>转义字符处理工具类：StringEscapeUtils</p>
 *
 * @author moubin.mo
 * @date: 2020/7/4 13:27
 */

public class TestReplaceAll {
	public static void main(String[] args) {
		test();
//		String test = "帮助中心book\n" +
//				"![](/uploads/202006/attach_161acf25ee0cfd3c.png)\n" +
//				"![](/uploads/202006/attach_161acebdd9e82efc.png)";
//
//		String key1 = "\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acf25ee0cfd3c.png\\)";
//		String key2 = "\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acebdd9e82efc.png\\)";
//		key1 = handleKey(key1);
//		key2 = handleKey(key2);
//		System.out.println("key1="+key1);
//		System.out.println("key2="+key2);
//
//		String a = "\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acf25ee0cfd3c.png\\)";
//
//		test = test.replaceAll("\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acf25ee0cfd3c.png\\)", "111");
////		test = test.replaceAll("\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acebdd9e82efc.png\\)", "222");
////		test = test.replaceAll(key1, "111");
////		test = test.replaceAll(key2, "222");
//		System.out.println(test);
	}

	private static String handleKey(String key) {
		key = key.replaceAll("\\!", "\\\\\\!");
		key = key.replaceAll("\\[", "\\\\\\[");
		key = key.replaceAll("\\]", "\\\\\\]");
		key = key.replaceAll("\\(", "\\\\\\(");
		key = key.replaceAll("\\/", "\\\\\\/");
		key = key.replaceAll("\\)", "\\\\\\)");
		return key;
	}

	public static boolean isSpecialChar(String str) {
//		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		String regEx = "[!()\\[\\]/]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}

	public static void test() {
		String test = "![](/uploads/202006/attach_161acf25ee0cfd3c.png)";
		test = test.replaceAll("\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acf25ee0cfd3c.png\\)", "111");
		System.out.println(test);


		String test1 = "![](/uploads/202006/attach_161acf25ee0cfd3c.png)";
		String key1 = "\\!\\[\\]\\(\\/uploads\\/202006\\/attach_161acf25ee0cfd3c.png\\)";
		test1 = test1.replaceAll(key1, "222");
		System.out.println(test1);

		String test2 = "![](/uploads/202006/attach_161acf25ee0cfd3c.png)";
		String key2 = handleKey(test2);
		test2 = test2.replaceAll(key2, "333");
		System.out.println(test2);

		String test4 = "帮助中心book\n" +
				"![](/uploads/202006/attach_161acf25ee0cfd3c.png)\n" +
				"![](/uploads/202006/attach_161acebdd9e82efc.png)";

		String key41 = "![](/uploads/202006/attach_161acf25ee0cfd3c.png)";
		String key42 = "![](/uploads/202006/attach_161acebdd9e82efc.png)";
		test4 = test4.replaceAll(handleKey(key41), getUrl(41));
		test4 = test4.replaceAll(handleKey(key42), getUrl(42));
		System.out.println(test4);
	}

	private static String getUrl(int i) {
		return String.valueOf(i);
	}
}
