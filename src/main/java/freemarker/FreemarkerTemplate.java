package freemarker;

/**
 * @author moubin.mo
 * @date: 2020/5/25 18:35
 */

public class FreemarkerTemplate {
	public final static String TEMPLATE_NAME = "name";
	public final static String TEMPLATE_TEST_1 =
			"您的会议即将开始，" +
			"<#if name?? >" +
			"  会议时间= ${name}" +
			"</#if>" +
			"<#if age?? >" +
			"  年龄 = ${age}"+
			"</#if>";
//	public final static String TEMPLATE_TEST_2 =
//			"<#if name ?? >" +
//					"客户名称为  ${name}"+
//					"</#if>" +
//					"<#if description?? >" +
//					"客户描述为 ${description}"+
//					"</#if>" +
//					"<#if id?? >" +
//					"客户id为 ${id} "+
//					"</#if>"
//			;

//	public final static String TEMPLATE_TEST_2 =
//			"<#if name ?? >" +
//			"客户名称为  ${name}"+
//			"</#if>" +
//			"<#if description?? >" +
//			"客户描述为 ${description}"+
//			"</#if>" +
//			"<#if id?? >" +
//			"客户id为 ${id} "+
//			"</#if>" +
//			"<#if user.name?? >" +
//			"客户联系人名称为 ${user.name} "+
//			"</#if>" +
//			"<#if user.age?? >" +
//			"客户联系人年龄为 ${user.age} "+
//			"</#if>" +
//			"<#if user.token?? >" +
//			"客户联系人手机号为 ${user.token} "+
//			"</#if>"
//	;

//	public final static String TEMPLATE_TEST_2 =
//			"<#if name ?? >" +
//					"客户名称为  ${name}"+
//					"</#if>" +
//					"<#if description?? >" +
//					"客户描述为 ${description}"+
//					"</#if>" +
//					"<#if id?? >" +
//					"客户id为 ${id} "+
//					"</#if>" +
//					"<#if user.name?? >" +
//					"客户联系人名称为 ${user.name} "+
//					"</#if>" +
//					"<#if user.age?? >" +
//					"客户联系人年龄为 ${user.age} "+
//					"</#if>" +
//					"<#if user.token?? >" +
//					"客户联系人手机号为 ${user.token} "+
//					"</#if>" +
//					"<#if address?? >" +
//					"客户地址为 "+
//					"<#list address as item>" +
//					"${item}," +
//					"</#list>"+
//					"</#if>"
//			;

//	public final static String TEMPLATE_TEST_2 =
//					"<#if name ?? >" +
//					"客户名称为  ${name}"+
//					"</#if>" +
//					"<#if description?? >" +
//					"客户描述为 ${description}"+
//					"</#if>" +
//					"<#if id?? >" +
//					"客户id为 ${id} "+
//					"</#if>" +
//					"<#if user.name?? >" +
//					"客户联系人名称为 ${user.name} "+
//					"</#if>" +
//					"<#if user.age?? >" +
//					"客户联系人年龄为 ${user.age} "+
//					"</#if>" +
//					"<#if user.token?? >" +
//					"客户联系人手机号为 ${user.token} "+
//					"</#if>" +
//					"<#if address?? >" +
//					"客户地址为 "+
//					"<#list address as item>" +
//					"${item}," +
//					"</#list>"+
//					"</#if>" +
//					"<#if members?? >" +
//					"客户公司成员有： "+
//					"<#list members as member>" +
//					"名字：${member.name}," +
//					"年龄：${member.age}," +
//					"手机号：${member.token}\n" +
//					"</#list>"
//			;

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
			"域空间为:${namespaceName}\n" +
			"<#if macro.name ?? >" +
			"客户名称为 ${macro.name}"+
			"</#if>" +
			"<#if macro.age?? >" +
				"客户描述为 ${macro.age}\n"+
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
				"客户名称为  ${dto.name} \n"+
				"</#if>" +
				"<#if dto.age?? >" +
				"客户描述为 ${dto.age}"+
				"</#if>"+
			"</#macro>"
			;


	public final static String
UPDATE_NAMESPACE_TEMPLATE =
			"编辑了${namespaceName}的域空间信息:\n" +
			"<@checkattribute2 previousNamespace.name,afterNamespace.name,'名称'/>"+
			"<@checkattribute2 previousNamespace.homeUrl,afterNamespace.homeUrl, 'PC管理后台域名'/>"+
			"<@checkattribute2 previousNamespace.pcHomeUrl,afterNamespace.pcHomeUrl, 'PC门户域名'/>"+
			"<@checkattribute2 previousNamespace.contentServerUrl,afterNamespace.contentServerUrl, '文件中转站域名'/>"+
			"<@checkattribute2 previousNamespace.opServerUrl,afterNamespace.opServerUrl, 'OP运营后台域名'/>"+
			"<@checkattribute2 previousNamespace.smsHeader,afterNamespace.smsHeader, '短信签名抬头'/>"+
			"<#macro checkattribute2 attribute1, attribute2, text>" +
			"<#if attribute1??>" +
//					"<!-- attribute1 不为空-->"+
				"<#if attribute2??>"+
					"<#if attribute1!=attribute2>"+
						"${text} 从 ${attribute1} 修改为 ${attribute2} \n"+
					"</#if>"+
				"<#else>"+
					"{text} 从 ${attribute1} 修改为 无\n"+
				"</#if>"+
			"<#else>"+
//					"<!-- attribute1 为空-->"+
				"<#if attribute2??>"+
					"{text} 修改为 ${attribute2} \n"+
				"</#if>"+
			"</#if>" +
			"</#macro>";

	public final static String CREATE_OR_DELETE_TEMPLATE =
			"<#if fromObject?? >" +
					"<#list fromObject.fields as field>"+
					"<#if field ??>"+
					"<@explain_field field />"+
					"</#if>"+
					"</#list>"+
					"</#if>"+
					"<#if toObject?? >" +
					"<#list toObject.fields as field>"+
					"<#if field ??>"+
					"<@explain_field field />"+
					"</#if>"+
					"</#list>"+
					"</#if>"+
					"<#macro explain_field field>" +
					"<#if field.field ?? >" +
					"${field.prefixText} : ${field.field} \n"+
					"</#if>" +
					"</#macro>"
			;

	public final static String UPDATE_TEMPLATE =
			"<#if fromObject?? && toObject?? >" +
					"<#list fromObject.fields as field1>"+
					"<#list toObject.fields as field2>"+
					"<#if field1.field==field2.field>"+
					"<@compareObjectField field1 field2 />"+
					"</#if>"+
					"</#list>"+
					"</#list>"+
					"</#if>"+
					"<#macro compareObjectField field1, field2>" +
					"<#if field1.value==field2.value>" +
					//"<!-- field1 不为空-->"+
					"<#if field2.value??>"+
					"<#if field1.field!=field2.field>"+
					"${field1.prefixText} 从 ${field1.value} 修改为 ${field2.value} \n"+
					"</#if>"+
					"<#else>"+
					"{field1.prefixText} 从 ${field1.value} 修改为 无\n"+
					"</#if>"+
					"<#else>"+
					//"<!-- field1 为空-->"+
					"<#if field2.value??>"+
					"{field2.prefixText} 修改为 ${field2.value} \n"+
					"</#if>"+
					"</#if>" +
					"</#macro>"
			;
}
