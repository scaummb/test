package freemarker.template;

/**
 * @author moubin.mo
 * @date: 2020/5/31 16:24
 */

public class TemplateConstants {
	public final static String FROM_OBJECT = "fromObject";
	public final static String TO_OBJECT = "toObject";
	public final static String DEFAULT_TEMPLATE = "";
	public final static String CREATE_OR_DELETE_TEMPLATE =
			"<#if fromObject?? >" +
					"<#list fromObject.fields as field>" +
					"<#if field ??>" +
					"<@explain_field field />" +
					"</#if>" +
					"</#list>" +
					"</#if>" +
					"<#if toObject?? >" +
					"<#list toObject.fields as field>" +
					"<#if field ??>" +
					"<@explain_field field />" +
					"</#if>" +
					"</#list>" +
					"</#if>" +
					"<#macro explain_field field>" +
					"<#if field.field ?? >" +
					"${field.prefixText} : ${field.field} \n" +
					"</#if>" +
					"</#macro>";

	public final static String UPDATE_TEMPLATE =
			"<#if fromObject?? && toObject?? >" +
					"<#list fromObject.fields as field1>" +
					"<#list toObject.fields as field2>" +
					"<#if field1.field==field2.field>" +
					"<@compareObjectField field1 field2 />" +
					"</#if>" +
					"</#list>" +
					"</#list>" +
					"</#if>" +
					"<#macro compareObjectField field1, field2>" +
					"<#if field1.value==field2.value>" +
					//"<!-- field1 不为空-->"+
					"<#if field2.value??>" +
					"<#if field1.field!=field2.field>" +
					"${field1.prefixText} 从 ${field1.value} 变更为 ${field2.value} \n" +
					"</#if>" +
					"<#else>" +
					"{field1.prefixText} 从 ${field1.value} 变更为 无\n" +
					"</#if>" +
					"<#else>" +
					//"<!-- field1 为空-->"+
					"<#if field2.value??>" +
					"{field2.prefixText} 修改为 ${field2.value} \n" +
					"</#if>" +
					"</#if>" +
					"</#macro>";

}
