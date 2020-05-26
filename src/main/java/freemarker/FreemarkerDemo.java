package freemarker;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:16
 */

public class FreemarkerDemo {
	private final static String templateKey = "test";
	private static Configuration templateConfig;
	private StringTemplateLoader templateLoader;

	public static void main(String[] args) throws IOException, TemplateException {
		/*Person a = new Person("a", 1);
		HashMap<String, String> map = new HashMap<>();
		map.put("name", a.getName());
		map.put("age", a.getAge().toString());

		FreemarkerDemo freemarkerDemo = new FreemarkerDemo();
		String result = freemarkerDemo.getLocaleTemplateString(map, FreemarkerTemplate.templateText_with_flt_instruments, "defaultValue");
		System.out.println(result);*/

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
		root.put("before", new HashMap<String,String>(){{
			put("name", "abc");put("age", null);}});
		root.put("after", new HashMap<String,String>(){{
			put("name", "abc");put("age", null);}});
//		Product latest = new Product();
//		latest.setUrl("products/greenmouse.html");
//		latest.setName("green mouse");
//		root.put("latestProduct", latest);

		/* Get the template (uses cache internally) */
		Template temp = new Template("a", FreemarkerTemplate.templateText_test,
				templateConfig);

		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, root));

		/* Merge data-model with template */
//		Writer out = new OutputStreamWriter(System.out);
//		temp.process(root, out);
	}

	public FreemarkerDemo() {
		templateLoader = new StringTemplateLoader();
		templateConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		templateConfig.setTemplateLoader(templateLoader);
		templateConfig.setTemplateUpdateDelay(0);
	}

	public static String getLocaleTemplateString(Object model, String templateText, String defaultValue) {
		try {
			Template freeMarkerTemplate = new Template(templateKey, templateText, templateConfig);
			return FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerTemplate, model);
		} catch(Exception e) {
			System.out.println(e);
		}
		return defaultValue;
	}

}

abstract class FreeMarkerTemplateUtils {
	public FreeMarkerTemplateUtils() {
	}

	public static String processTemplateIntoString(Template template, Object model) throws IOException, TemplateException {
		StringWriter result = new StringWriter();
		template.process(model, result);
		return result.toString();
	}

}

class SuperMan{
	private String name;
	private Integer age;
	private String ability;

	public SuperMan(String name, Integer age, String ability) {
		this.name = name;
		this.age = age;
		this.ability = ability;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

class Person {
	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

class Monkey{
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}