package Utils.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/5/22 10 :03
 *
 * @author moubin.mo
 */

/**
 * todo 将list转化为array的时候，第二种重构方法更方便
 */
public class test02 {
	public static void main(String[] args) {
		List<String> phones = new ArrayList<String>() {{
			add("1991881181");
			add("2929238838");
		}};
		String[] phoneArray = new String[phones.size()];
		phones.toArray(phoneArray);
		System.out.println("phone=" + phones);
	}
}
