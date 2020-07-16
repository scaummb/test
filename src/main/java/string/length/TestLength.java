package string.length;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moubin.mo
 * @date: 2020/6/23 15:02
 */

public class TestLength {

	private static final String regex = "\\!\\[\\]\\(.*\\)";

	public static void main(String[] args) {
		String a = "![](/uploads/201803/codeformat/attach_151b07131280100e.png)\n" +
				"- 检查插件是否安装成功\n" +
				"![](/uploads/201803/codeformat/attach_151b0715e77d411a.png)\n" +
				"- 添加自己的配置文件，要检查的项目，\n" +
				"![](/uploads/201803/codeformat/attach_151b07189d3599f1.png)";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(a);
		while (m.find()){
			System.out.println("Match " + m.group() + " , at positions " + m.start() + " - " + (m.end() - 1));
		}
	}
}
