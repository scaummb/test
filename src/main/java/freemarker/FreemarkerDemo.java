package freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import freemarker.bean.ContactUser;
import freemarker.bean.Macro;
import freemarker.bean.Namespace;
import freemarker.bean.OrganizationCustomer;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.*;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:16
 */

public class FreemarkerDemo {
	private final static String templateKey = "test";
	private static Configuration templateConfig;
	private StringTemplateLoader templateLoader;

	public static void main(String[] args) throws IOException, TemplateException {
//		test00();
//		test01();
//		test02();
//		test03();
//		test04();
		test06();
	}

	public static void test06() throws IOException, TemplateException {
		Namespace previousNamespace = new Namespace(1L, "深圳湾1","homeUrl1","pcHomeUrl1","contentServerUrl1","opServerUrl1", "smsHeader1");
		Namespace afterNamespace = new Namespace(2L, "深圳湾2","homeUrl2","pcHomeUrl2","contentServerUrl2","opServerUrl1", "smsHeader1");
		Map root = new HashMap(){{
			put("namespaceName","深圳湾");
			put("previousNamespace",previousNamespace);
			put("afterNamespace",afterNamespace);}};
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.UPDATE_NAMESPACE_TEMPLATE,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, root));

	}

	public static void test00() throws IOException, TemplateException {
		Map root = new HashMap(){{put("name","zuolin");put("age",null);}};
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_1,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, root));
	}

	public static void test01() throws IOException, TemplateException {
		OrganizationCustomer organizationCustomer = buildCustomer();
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_2,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, organizationCustomer));
	}

	public static void test02() throws IOException, TemplateException {
		OrganizationCustomer organizationCustomer = buildCustomer();
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_3,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, organizationCustomer));
	}

	public static void test03() throws IOException, TemplateException {
		OrganizationCustomer organizationCustomer = buildCustomer();
		HashMap<String, Object> map = new HashMap<>();
		map.put("organizationCustomer", organizationCustomer);
		map.put("namespaceId", 11);
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_4,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, map));
	}

	public static void test04() throws IOException, TemplateException {
		Macro macro = buildMacro();
		HashMap<String, Object> map = new HashMap(){{put("macro", macro);put("namespaceId", 11);}};
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_5,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, map));
	}

	public static void test05() throws IOException, TemplateException {

	}

	private static Macro buildMacro() {
		//循环嵌套
		Macro macro = new Macro();
		macro.setAge(1);
		macro.setName("1");
		List<Macro> objects = new ArrayList<Macro>(){{add(macro);}};

		Macro macro2 = new Macro();
		macro2.setAge(2);
		macro2.setName("2");
		macro.setDtos(objects);
		Macro macro4 = new Macro();
		macro4.setAge(4);
		macro4.setName("4");
		List<Macro> objects2 = new ArrayList<Macro>(){{add(macro2);add(macro4);}};

		Macro macro3 = new Macro();
		macro3.setAge(2);
		macro3.setName("2");
		macro3.setDtos(objects2);
		return macro3;
	}

	/**
	 * <p>处理传入对象</p>
	 */
	private static Map convertObjectToMap(Object obj) {
		if (obj == null || obj instanceof String || obj instanceof Number
		|| obj instanceof java.util.Date || obj instanceof java.sql.Date ||obj instanceof java.sql.Time
		|| obj instanceof java.sql.Timestamp || obj instanceof Collection || obj instanceof Map
		|| obj instanceof Boolean || obj instanceof Iterator || obj instanceof Enumeration || obj instanceof Iterable) {
			return new HashMap<>();
		}
		return handleUnknownType(obj);
	}

	/**
	 * <p>处理未知类型对象</p>
	 */
	private static Map handleUnknownType(Object obj) {
		JSONObject json = (JSONObject) JSON.toJSON(obj);
		return json;

//		HashMap<String, Object> map = new HashMap<>();
//		final Class<?> objClass = obj.getClass();
//		Field[] declaredFields = objClass.getDeclaredFields();
//		if (declaredFields.length > 0){
//			for (Field field : declaredFields){
//				field.setAccessible(true);
//				try {
//					map.put(field.getName(), field.get(obj));
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return map;
	}

	private static OrganizationCustomer buildCustomer() {
		OrganizationCustomer organizationCustomer = new OrganizationCustomer();
		organizationCustomer.setId(1L);
		organizationCustomer.setDescription("description");
		organizationCustomer.setName("name");
		ContactUser user = new ContactUser();
		user.setAge(25);
		user.setName("test");
		user.setToken("1234356456");
		organizationCustomer.setUser(user);

		ArrayList<String> list = new ArrayList(){{add("1123");add("123123123");add("54489798");}};
		organizationCustomer.setAddress(list);

		List<ContactUser> members = new ArrayList(){{
			add(new ContactUser("a", 1, "111"));
			add(new ContactUser("b", 2, "222"));
			add(new ContactUser("c", 3, "333"));
		}};
		organizationCustomer.setMembers(members);

		List<OrganizationCustomer> customers = new ArrayList(){{
			add(new OrganizationCustomer(2L,"test02","description02"));
			add(new OrganizationCustomer(3L,"test03","description03"));
			add(new OrganizationCustomer(4L,"test04","description04"));
		}};
		organizationCustomer.setCustomers(customers);
		return organizationCustomer;
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
