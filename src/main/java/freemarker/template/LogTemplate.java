package freemarker.template;

/**
 * <ul>
 * <li>description: 普通文案模板</li>
 * <li>data: 对象列表{fromObject:{},toObject:{}}</li>
 * </ul>
 */
public class LogTemplate {
	private String description;
	private LogTemplateObject dataObject;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LogTemplateObject getDataObject() {
		return dataObject;
	}

	public void setDataObject(LogTemplateObject dataObject) {
		this.dataObject = dataObject;
	}

}
