package nullcase.case2;

import javax.validation.constraints.NotNull;

/**
 * <ul>
 * <li>scope: 业务范围</li>
 * <li>code: 业务模板类型</li>
 * <li>locale: 语言类型</li>
 * </ul>
 */
public class TemplateData {
	@NotNull
	private String scope;
	@NotNull
	private Integer code;
	@NotNull
	private String locale;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
