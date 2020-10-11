package kafka.consumer;

public enum MsgType {
	SINGLE((byte)1, "单次"),
	BATCH((byte)2, "批次")
	;
	private Byte type;
	private String description;

	public static MsgType fromCode(byte byteValue) {
		for (MsgType type : MsgType.values()){
			if (type.type.equals(byteValue)) {
				return type;
			}
		}
		return MsgType.SINGLE;
	}

	public String getDescription() {
		return description;
	}

	public Byte getType() {
		return type;
	}

	MsgType(Byte type, String description) {
		this.type = type;
		this.description = description;
	}
}
