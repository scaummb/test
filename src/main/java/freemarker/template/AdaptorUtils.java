package freemarker.template;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
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
	 *     设置data的特殊字段数据
	 *     {fromObject:{{field:xx,value:xx,prefix:xx,hideFlag:xx,hideText:xx}},
	 *     toObject:{{field:xx,value:xx,prefix:xx,hideFlag:xx,hideText:xx}}}
	 * </p>
	 */
	public static void handleDataMap(Map<String,LogTemplateObject> templateObjects, Object fromObject, Object toObject, Map<String,Object> data) {
		if (CollectionUtils.isEmpty(templateObjects)){
			return;
		}

		if (!ObjectUtils.isEmpty(templateObjects.get(TemplateConstants.FROM_OBJECT))){
			LogTemplateObject fromObjectFormatter = templateObjects.get(TemplateConstants.FROM_OBJECT);
			Field[] declaredFields = fromObject.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				for (LogTemplateObjectField objectField :fromObjectFormatter.getFields()){
					if (objectField.getField().equals(field.getName())){
						try {
							objectField.setValue(String.valueOf(field.get(fromObject)));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			data.putIfAbsent(TemplateConstants.FROM_OBJECT, fromObjectFormatter);
		}

		if (!ObjectUtils.isEmpty(templateObjects.get(TemplateConstants.TO_OBJECT))){
			LogTemplateObject toObjectFormatter = templateObjects.get(TemplateConstants.TO_OBJECT);
			Field[] declaredFields = toObject.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				for (LogTemplateObjectField objectField :toObjectFormatter.getFields()){
					if (objectField.getField().equals(field.getName())){
						try {
							objectField.setValue(String.valueOf(field.get(toObject)));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			data.putIfAbsent(TemplateConstants.TO_OBJECT, toObjectFormatter);
		}
	}

	public static String getTemplateSourceCode(String description, String templateFields) {
		StringBuffer stringBuffer = new StringBuffer();
		if (StringUtils.isEmpty(description)){
			stringBuffer.append(description);
		}
		if (StringUtils.isEmpty(templateFields)){
			stringBuffer.append(templateFields);
		}
		return stringBuffer.toString();
	}

}
