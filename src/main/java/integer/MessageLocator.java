package integer;

/**
 * @author moubin.mo
 * @date: 2019/9/18 12:15
 */

public class MessageLocator {
	private static final long serialVersionUID = 5586717671485685911L;
	private String messageBoxKey;
	private Long anchor;

	public MessageLocator(String messageBoxKey) {
		this.messageBoxKey = messageBoxKey;
	}

	public String getMessageBoxKey() {
		return this.messageBoxKey;
	}

	public void setMessageBoxKey(String messageBoxKey) {
		this.messageBoxKey = messageBoxKey;
	}

	public Long getAnchor() {
		return this.anchor;
	}

	public void setAnchor(Long anchor) {
		this.anchor = anchor;
	}
}
