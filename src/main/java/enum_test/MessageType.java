package enum_test;

/**
 * 消息类型枚举
 * <ul>
 * <li><p>MESSAGE：消息</p></li>
 * <li><p>EMAIL：邮件</p></li>
 * <li><p>SMS：短信</p></li>
 * <li><p>WECHAT：微信消息</p></li>
 * </ul>
 * @author moubin.mo
 * @date 2019-10-6 16:52:58
 */
public enum MessageType {
	MESSAGE("MESSAGE"),
	EMAIL("EMAIL"),
	SMS("SMS"),
	WECHAT("WECHAT"),
	;

	private String type;

	MessageType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static MessageType fromCode (String messageType){
		for (MessageType type : MessageType.values()){
			if (type.getType().equals(messageType)){
				return type;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(fromCode("MESSAGE"));
	}
}
