package freemarker;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:35
 */

public class FreemarkerTemplate {
	public final static String templateText = "新增用户，名字叫${name}，年龄为${age}";
	public final static String templateText_with_flt_instruments = "新增用户，名字叫${name}，年龄为${age}，";
	public final static String templateText_with_flt_instruments1 = "新增用户，名字叫${ClassName-fieldName.name}，年龄为${age}，";
	public final static String templateText_test = "<#if before.name != after.name>" +
			"  名称从${before.name} 修改到 ${after.name}" +
			"</#if>" +
			"<#if fjdsklfjdlskfj?? || before.age?? || after.age?? >" +
			"  名称从${before.age} 修改到 ${after.age}" +
			"<#else>" +
			"  x is not 1 nor 2 nor 3 nor 4\n" +
			"</#if>";
}
