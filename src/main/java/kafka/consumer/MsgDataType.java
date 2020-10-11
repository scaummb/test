package kafka.consumer;

public enum MsgDataType {
	ORGANIZATION((byte)1,"部门或企业"),
	ORGANIZATION_MEMBER((byte)2,"组织机构成员")
	;

	private Byte type;
	private String description;

	public Byte getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	MsgDataType(Byte type, String description) {
		this.type = type;
		this.description = description;
	}
}
