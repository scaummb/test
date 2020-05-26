package freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:49
 */

public class Test {

	public static void main(String[] args) throws Exception {

		/* ------------------------------------------------------------------------ */
		/* You should do this ONLY ONCE in the whole application life-cycle:        */

		/* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
//		cfg.setDirectoryForTemplateLoading(new File("/templates"));
		// Recommended settings for new projects:
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);

		/* ------------------------------------------------------------------------ */
		/* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

		/* Create a data-model */
		Map root = new HashMap();
		root.put("user", "Big Joe");
//		Product latest = new Product();
//		latest.setUrl("products/greenmouse.html");
//		latest.setName("green mouse");
//		root.put("latestProduct", latest);

		/* Get the template (uses cache internally) */
//		Template temp = new Template()
//
//		/* Merge data-model with template */
//		Writer out = new OutputStreamWriter(System.out);
//		temp.process(root, out);
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.

		get(new SuperMan("", 11,""));
	}

	public static void get(Object t) throws IllegalAccessException, InstantiationException {
		t.getClass();
		System.out.println(t.getClass());
		Class<?> aClass = t.getClass();
		Field[] declaredFields = aClass.getDeclaredFields();



		ClassLoader.getSystemResource();
	}
}
