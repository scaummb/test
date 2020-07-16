package regex.replace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author moubin.mo
 * @date: 2020/7/3 00:43
 */

public class TestPattern {
	public static void main(String[] args) {
		String testText = TextContents.TEXT_1 ;
		String regex = "\\!\\[\\]\\(.*\\)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(testText);
		ArrayList<String> al=new ArrayList<String>();

		Map<String, String> map = new HashMap<>();

//		while (m.find()) {
//			al.add(m.group(0));
//			System.out.println("Second Match " + m.group() + " at positions " + m.start() + " - " + (m.end() - 1));
//			map.put(m.group(0), getPictureUrl(m.group(0)));
//			System.out.println(testText.substring(m.start()+4, m.end()-1));
//		}

		try{
			throw new RuntimeException("123123123");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("123");
		}

		for (int i =9; i>0; i--){
			System.out.println(i);
		}
	}

	private static String getPictureUrl(String match) {
		return "http://coredemo.zuolin.com";
	}
}
