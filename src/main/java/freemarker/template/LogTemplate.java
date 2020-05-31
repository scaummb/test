package freemarker.template;

import java.util.Map;

/**
 * <ul>
 * <li>description: 普通文案模板</li>
 * <li>data: 对象列表{fromObject:{},toObject:{}}</li>
 * </ul>
 */
public class LogTemplate {
	private String description;
	private Map<String, LogTemplateObject> data;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, LogTemplateObject> getData() {
		return data;
	}

	public void setData(Map<String, LogTemplateObject> data) {
		this.data = data;
	}
}
