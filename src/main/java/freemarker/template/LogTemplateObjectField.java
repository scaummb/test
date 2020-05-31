package freemarker.template;

/**
 * <ul>
 * <li>prefixText: 字段描述文本</li>
 * <li>field: 字段属性名</li>
 * <li>value: 字段值</li>
 * <li>hideFlag: 字段隐藏标识</li>
 * <li>hideText: 字段隐藏展示文本</li>
 * </ul>
 */
public class LogTemplateObjectField {
	private String prefixText;
	private String field;
	private String value;
	private Byte hideFlag;
	private String hideText;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPrefixText() {
		return prefixText;
	}

	public void setPrefixText(String prefixText) {
		this.prefixText = prefixText;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Byte getHideFlag() {
		return hideFlag;
	}

	public void setHideFlag(Byte hideFlag) {
		this.hideFlag = hideFlag;
	}

	public String getHideText() {
		return hideText;
	}

	public void setHideText(String hideText) {
		this.hideText = hideText;
	}
}
