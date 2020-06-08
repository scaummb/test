package freemarker.template;


/**
 * <ul>
 * <li>text: 字段描述文本</li>
 * <li>field: 字段属性名</li>
 * <li>value: 字段值</li>
 * <li>mode: 字段展示模式 </li>
 * </ul>
 */
public class LogTemplateObjectField {
	private String text;
	private String field;
	private String value;
	private Byte mode;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Byte getMode() {
		return mode;
	}

	public void setMode(Byte mode) {
		this.mode = mode;
	}
}
