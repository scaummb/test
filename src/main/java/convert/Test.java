package convert;

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2020/1/2 18:14
 */

public class Test {
	public static void main(String[] args) {
		AObject aObject = new AObject();
		aObject.setId(11L);
		aObject.setName("aObject");
		ArrayList arrayList = new ArrayList(10) {{
			add(11);
		}};
		aObject.setIds(arrayList);
		BObject bObject = ConvertHelper.convert(aObject, BObject.class);
		System.out.println(bObject);
	}
}
