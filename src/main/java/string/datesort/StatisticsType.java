package string.datesort;

public enum StatisticsType {
	DEFAULT((byte) 0, "默认"),
	HOURLY((byte) 1, "每小时"),
	DAILY((byte) 2, "每天"),
	MONTHLY((byte) 3, "每月");

	private Byte code;
	private String text;

	StatisticsType(Byte code, String text) {
		this.code = code;
		this.text = text;
	}

	public Byte getCode() {
		return this.code;
	}

	public String getText() {
		return this.text;
	}

	public static StatisticsType getCode(Byte code) {
		if (code == null) {
			return StatisticsType.HOURLY;
		}
		for (StatisticsType type : StatisticsType.values()) {
			if (code.equals(type.getCode())) {
				return type;
			}
		}
		return StatisticsType.HOURLY;
	}

}
