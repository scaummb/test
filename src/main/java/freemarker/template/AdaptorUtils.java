package freemarker.template;

import convert.ConvertHelper;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.mortbay.util.ajax.JSON;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/5/31 16:56
 */

public class AdaptorUtils {
	/**
	 * <p>获取模板key</p>
	 * @param scope
	 * @param code
	 * @param locale
	 */
	public static String getTemplateKey(String scope, int code, String locale) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(scope);
		strBuilder.append(".");
		strBuilder.append(locale);
		strBuilder.append(".");
		strBuilder.append(code);
		return strBuilder.toString();
	}


	/**
	 * <p>
	 *     解释设置data的字段数据
	 *     {fromObject:{{field:xx,value:xx,text:xx,mode:xx}},
	 *     toObject:{{field:xx,value:xx,text:xx,mode:xx}}}
	 * </p>
	 * @param templateObject 业务模板数据
	 * @param fromObject 操作后数据对象
	 * @param toObject 操作前数据对象
	 * @param data 模板数据Map，是给freemarker处理准备的map
	 */
	public static void handleDataMap(LogTemplateObject templateObject, Object fromObject, Object toObject, Map<String,Object> data) {
		if (ObjectUtils.isEmpty(templateObject)){
			return;
		}

		// 设置 fromTemplateObject 进 freemarker 数据解析模板
		if (!ObjectUtils.isEmpty(fromObject)){
			LogTemplateObject fromTemplateObject = ConvertHelper.convert(templateObject, LogTemplateObject.class);
			ArrayList<LogTemplateObjectField> fieldArrayList = new ArrayList();
			Field[] allFields = FieldUtils.getAllFields(fromObject.getClass());
			for (Field field : allFields) {
				field.setAccessible(true);
				for (LogTemplateObjectField objectField :fromTemplateObject.getFields()){
					if (objectField.getField().equals(field.getName())){
						try {
							LogTemplateObjectField newField = ConvertHelper.convert(objectField, LogTemplateObjectField.class);
							newField.setValue(String.valueOf(field.get(fromObject)));
							fieldArrayList.add(newField);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			fromTemplateObject.setFields(fieldArrayList);
			data.putIfAbsent(TemplateConstants.FROM_OBJECT, fromTemplateObject);
		}

		System.out.println(JSON.toString(data));

		// 设置 toTemplateObject 进 freemarker 数据解析模板
		if (!ObjectUtils.isEmpty(toObject)){
			LogTemplateObject toTemplateObject = ConvertHelper.convert(templateObject, LogTemplateObject.class);
			ArrayList<LogTemplateObjectField> fieldArrayList = new ArrayList();
			Field[] allFields = FieldUtils.getAllFields(toObject.getClass());
			for (Field field : allFields) {
				field.setAccessible(true);
				for (LogTemplateObjectField objectField :toTemplateObject.getFields()){
					if (objectField.getField().equals(field.getName())){
						try {
							LogTemplateObjectField newField = ConvertHelper.convert(objectField, LogTemplateObjectField.class);
							newField.setValue(String.valueOf(field.get(toObject)));
							fieldArrayList.add(newField);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}

			toTemplateObject.setFields(fieldArrayList);
			data.putIfAbsent(TemplateConstants.TO_OBJECT, toTemplateObject);
		}

		System.out.println(JSON.toString(data));
	}

	public static String getTemplateSourceCode(String description, String templateFields) {
		StringBuffer stringBuffer = new StringBuffer();
		if (!StringUtils.isEmpty(description)){
			stringBuffer.append(description);
		}
		if (!StringUtils.isEmpty(templateFields)){
			stringBuffer.append(templateFields);
		}
		return stringBuffer.toString();
	}

}
