package freemarker.template;

import java.util.List;

/**
 * <ul>
 * <li>fields: 对象属性列表</li>
 * </ul>
 */
public class LogTemplateObject {
	private List<LogTemplateObjectField> fields;

	public List<LogTemplateObjectField> getFields() {
		return fields;
	}

	public void setFields(List<LogTemplateObjectField> fields) {
		this.fields = fields;
	}
}
