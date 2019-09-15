package string;

import org.apache.commons.lang.StringUtils;

/**
 * @author moubin.mo
 * @date: 2019/9/15 15:23
 */

public class TestEquals {
	public static void main(String[] args){
		String name = "mmb";
		String age = null;
		Integer weight = 100;
		System.out.println(StringUtils.equals(name, "mmb"));
		System.out.println(StringUtils.equals(age, null));
	}
}
