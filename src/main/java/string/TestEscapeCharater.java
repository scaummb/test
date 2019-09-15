package string;

import org.apache.commons.lang.StringUtils;

/**
 * 测试替换转义字符
 * @author moubin.mo
 * @date: 2019/8/28 15:48
 */

public class TestEscapeCharater {
	public static void main(String[] args){
		String s1 = "123456()()()";
		String s2 = handleEscapeCharacter(s1);
		String s3 = handleEscapeCharacter(s1);
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
		System.out.println("s3="+s3);

	}

	/**
	 * 处理文本中的转义字符并返回
	 * @param originalString
	 * @return afterString
	 */
	public static String handleEscapeCharacter(String originalString){
		if(StringUtils.isEmpty(originalString)){
			return originalString;
		}

		return originalString.replace("\\", "\\\\")
				.replace("*", "\\*").replace("+", "\\+")
				.replace("|", "\\|").replace("{", "\\{")
				.replace("}", "\\}").replace("(", "\\(")
				.replace(")", "\\)").replace("^", "\\^")
				.replace("$", "\\$").replace("[", "\\[")
				.replace("]", "\\]").replace("?", "\\?")
				.replace(",", "\\,").replace(".", "\\.")
				.replace("&", "\\&").replace("（", "\\（")
				.replace("）", "\\）")
				;
	}
}
