package freemarker;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:35
 */

public class FreemarkerTemplate {
	public final static String TEMPLATE_NAME = "name";
	public final static String TEMPLATE_TEST_1 = "<#if before.name != after.name>" +
			"  名称从${before.name} 修改到 ${after.name}" +
			"</#if>" +
			"<#if fjdsklfjdlskfj?? || before.age?? || after.age?? >" +
			"  名称从${before.age} 修改到 ${after.age}" +
			"<#else>" +
			"  x is not 1 nor 2 nor 3 nor 4" +
			"</#if>";
	public final static String TEMPLATE_TEST_2 =
			"<#if name ?? >" +
					"客户名称为  ${name}"+
			"</#if>" +
			"<#if description?? >" +
					"客户描述为 ${description}"+
			"</#if>" +
			"<#if id?? >" +
					"客户id为 ${id} "+
			"</#if>" +
			"<#if user.name?? >" +
					"客户联系人名称为 ${user.name} "+
			"</#if>" +
			"<#if user.age?? >" +
					"客户联系人年龄为 ${user.age} "+
			"</#if>" +
			"<#if user.token?? >" +
					"客户联系人手机号为 ${user.token} "+
			"</#if>" +
			"<#if address?? >" +
					"客户地址为 "+
					"<#list address as item>" +
						"${item}," +
					"</#list>"+
			"</#if>" +
			"<#if members?? >" +
					"客户公司成员有： "+
					"<#list members as member>" +
						"名字：${member.name}," +
						"年龄：${member.age}," +
						"手机号：${member.token}\n" +
					"</#list>"+
			"</#if>" +
			"<#if customers?? >" +
					"客户公司成员有： "+
					"<#list customers as customer>" +
							"客户名称为  ${customer.name}"+
							"客户描述为 ${customer.description}"+
							"客户id为 ${customer.id} "+
					"</#list>"+
			"</#if>"
			;

	public final static String TEMPLATE_TEST_3 =
			"<#if name ?? >" +
					"客户名称为  ${name}"+
					"</#if>" +
					"<#if description?? >" +
					"客户描述为 ${description}"+
					"</#if>" +
					"<#if id?? >" +
					"客户id为 ${id} "+
					"</#if>" ;

	public final static String TEMPLATE_TEST_4 =
			"域空间为:${namespaceId}" +
 			"<#if organizationCustomer.name ?? >" +
					"客户名称为  ${organizationCustomer.name}"+
					"</#if>" +
					"<#if organizationCustomer.description?? >" +
					"客户描述为 ${organizationCustomer.description}"+
					"</#if>" +
					"<#if organizationCustomer.id?? >" +
					"客户id为 ${organizationCustomer.id} "+
					"</#if>" ;
	public static final String TEMPLATE_TEST_5 =
			"域空间为:${namespaceId}" +
			"<#if macro.name ?? >" +
			"客户名称为 ${macro.name}"+
			"</#if>" +
			"<#if macro.age?? >" +
				"客户描述为 ${macro.age}"+
			"</#if>"+
			"<#if macro.dtos?? >" +
				"<#list macro.dtos as item>"+
					"<#if item ??>"+
						"<@explain_macro item />"+
					"</#if>"+
				"</#list>"+
			"</#if>"+
			"<#macro explain_macro dto>" +
				"<#if dto.name ?? >" +
				"客户名称为  ${dto.name}"+
				"</#if>" +
				"<#if dto.age?? >" +
				"客户描述为 ${dto.age}"+
				"</#if>"+
			"</#macro>"
			;
}
