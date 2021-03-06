package object;

/**
 * <ul>
 *     <li>((byte) 0):FALSE </li>
 *     <li>((byte) 1): TRUE</li>
 * </ul>
 *
 * @author moubin.mo
 * @date: 2019/11/21 15:59
 */
public enum TrueOrFalseCode {

	FALSE((byte) 0),
	TRUE((byte) 1);

	private Byte code;

	TrueOrFalseCode(Byte code) {
		this.code = code;
	}

	public Byte getCode() {
		return code;
	}

	public static TrueOrFalseCode fromCode(Byte code) {
		if (code != null) {
			for (TrueOrFalseCode type : TrueOrFalseCode.values()) {
				if (type.getCode().equals(code)) {
					return type;
				}
			}
		}
		return null;
	}
}
