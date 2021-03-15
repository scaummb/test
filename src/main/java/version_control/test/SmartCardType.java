package version_control.test;

/**
 * <ul>
 * <li>SMART_CARD_PAY((byte) 1, "支付功能"): SMART_CARD_PAY</li>
 * <li>SMART_CARD_ACLINK((byte) 2, "门禁功能"): SMART_CARD_ACLINK</li>
 * <li>SMART_CARD_CUSTOM((byte) 3, "第三方对接功能"): SMART_CARD_CUSTOM</li>
 * </ul>
 */
public enum SmartCardType {
	SMART_CARD_PAY((byte) 1, "支付功能"),
	SMART_CARD_ACLINK((byte) 2, "门禁功能"),
	SMART_CARD_CUSTOM((byte) 3, "第三方对接功能");

	private byte code;
	private String name;

	public String getName() {
		return name;
	}

	public byte getCode() {
		return this.code;
	}

	private SmartCardType(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	public static SmartCardType fromCode(Byte code) {
		if (code == null) {
			return null;
		}

		switch (code.byteValue()) {
			case 1:
				return SMART_CARD_PAY;
			case 2:
				return SMART_CARD_ACLINK;
			case 3:
				return SMART_CARD_CUSTOM;

		}

		return null;
	}
}
