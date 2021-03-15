package mood;

import java.util.regex.Pattern;

/**
 * Date: 2019/8/7 20 :07
 *
 * @author moubin.mo
 */

public class testRegular {
	public static void main(String[] args) {
		String test1 = new String("144421adf22983@zuolin.com");
		String test2 = new String("1444222983zuolin.com");

		String regular = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

		Pattern compile = Pattern.compile(regular);

		System.out.println("test1:" + test1 + "  " + compile.matcher(test1).matches());
		System.out.println("test2:" + test2 + "  " + compile.matcher(test2).matches());

	}
}
