package object;

/**
 * @author moubin.mo
 * @date: 2019/11/20 19:30
 */

public enum NamespaceUserType {
	WANKE("wanke"),
	WX("wx"),
	JINDIE("jindie"),
	GUOMAO("guomao"),
	ANBANG("anbang"),
	ALIPAY("alipay"),
	ZHENZHIHUI("zhenzhihui");

	private String code;

	private NamespaceUserType(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static NamespaceUserType fromCode(String code) {
		if (code != null) {
			NamespaceUserType[] values = values();
			NamespaceUserType[] var2 = values;
			int var3 = values.length;

			for(int var4 = 0; var4 < var3; ++var4) {
				NamespaceUserType value = var2[var4];
				if (code.equals(value.code)) {
					return value;
				}
			}
		}

		return null;
	}
}
