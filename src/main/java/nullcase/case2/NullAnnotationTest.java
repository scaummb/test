package nullcase.case2;

import org.springframework.util.ObjectUtils;

/**
 * @author moubin.mo
 * @date: 2020/8/24 16:13
 */

public class NullAnnotationTest {
	public static void main(String[] args) throws Exception {
		test(new TemplateData());
	}

	private static void test(TemplateData templateData) throws Exception {
		if (ObjectUtils.isEmpty(templateData.getCode()) ||
				ObjectUtils.isEmpty(templateData.getLocale()) ||
				ObjectUtils.isEmpty(templateData.getScope())
				){
			throw new Exception("ex");
		}

	}
}
