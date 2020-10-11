package kafka.consumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author moubin.mo
 * @date: 2020/10/11 23:13
 */

public class Consumer {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.submit(new MsgEventLoop());
		for (int i=0;i<100;i++){
			KafkaMessage kafkaMessage = new KafkaMessage();
			kafkaMessage.setMsgType(getMsgType().getType());
			MsgEventLoop.accept(kafkaMessage);
		}
	}

	private final static MsgType getMsgType(){
		Integer i = new Random().nextInt(1);
		return MsgType.fromCode(i.byteValue());
	}
	public Consumer() {
	}


}
/**
 * {@link MsgType}
 * {@link MsgDataType}
 *
 */
class KafkaMessage{
	private Byte msgType;
	private Byte msgDataType;
	private List<SyncData> members;

	public Byte getMsgType() {
		return msgType;
	}

	public void setMsgType(Byte msgType) {
		this.msgType = msgType;
	}

	public Byte getMsgDataType() {
		return msgDataType;
	}

	public void setMsgDataType(Byte msgDataType) {
		this.msgDataType = msgDataType;
	}

	public List<SyncData> getMembers() {
		return members;
	}

	public void setMembers(List<SyncData> members) {
		this.members = members;
	}

	public KafkaMessage() {
	}
}

class SyncData {
	private Integer namespaceId;
	private Long organizationId;
	private Long targetId;

	public Integer getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(Integer namespaceId) {
		this.namespaceId = namespaceId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}
}