package localbus;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author moubin.mo
 * @date: 2020/11/16 20:14
 */

public class LocalBusOneshotSubscription implements LocalBusSubscriber {

	private String subject;
	private LocalBusOneshotSubscriber subscriber;
	private Long timeout;
	@Autowired
	private LocalBusTaskScheduler scheduler;

	public LocalBusOneshotSubscription setSubject(String subject) {
		this.subject = subject;
		return this;
	}

	public LocalBusOneshotSubscription setSubscriber(LocalBusOneshotSubscriber subscriber) {
		this.subscriber = subscriber;
		return this;
	}

	public LocalBusOneshotSubscription setTimeout(Long timeout) {
		this.timeout = timeout;
		return this;
	}

	@Override
	public Action onLocalBusMessage(Object var1, String var2, Object var3, String var4) {
		return null;
	}
}
