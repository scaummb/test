package kafka.consumer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author moubin.mo
 * @date: 2020/10/11 23:22
 */
// 启动后轮训开启
public class MsgEventLoop implements Callable, ApplicationRunner {
	//四种同步策略:
	// 1.单次+企业
	// 2.单次+成员
	// 3.批次+企业
	// 4.批次+成员

	private final static ConcurrentHashMap<String, List<SyncData>> map = new ConcurrentHashMap();

	// 1/2/3的时间范围内操作去重 与 批量同步(成员数据-50，)
	@Override
	public Object call() throws Exception {
		for (; ; ) {
			for (String key : map.keySet()) {
				switch (key) {
					case "1-2":
						//todo post now  单次+成员
						//4：POST right now
					case "1-1":
						//todo remove duplicate,单次+企业, cache：key=orgId-syncTime，value=orgId,有效时间30s
						//1,2,3：POST every 1min
					case "2-1":
						//todo remove duplicate,批次+企业, cache：key=orgId-syncTime，value=[orgId],有效时间30s
						//1,2,3：POST every 1min,请求数据跟服务器配置有关，在Tomcat下取消POST大小的限制（Tomcat默认2M）
					case "2-2":
						//todo remove duplicate,批次+成员, cache：key=orgId-syncTime，value="[uid]",有效时间10s
						//1,2,3：POST every 1min
					default:
				}
			}
			System.out.println("test... " + System.currentTimeMillis());
			Thread.sleep(5000);
		}
	}

	public final static void accept(KafkaMessage kafkaMessage) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(kafkaMessage.getMsgType()).append("-").append(kafkaMessage.getMsgDataType());
		List<SyncData> list = (List<SyncData>) map.getOrDefault(buffer.toString(), new ArrayList<SyncData>());
		map.put(buffer.toString(), list);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
