package freemarker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import freemarker.bean.ContactUser;
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
		test01();
	}

	public static void test01() throws IOException, TemplateException {
		OrganizationCustomer organizationCustomer = buildCustomer();
		Map root = convertObjectToMap(organizationCustomer);
		System.out.println(root);
		Template temp = new Template(FreemarkerTemplate.TEMPLATE_NAME, FreemarkerTemplate.TEMPLATE_TEST_2,
				templateConfig);
		System.out.println(FreeMarkerTemplateUtils.processTemplateIntoString(temp, root));
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
