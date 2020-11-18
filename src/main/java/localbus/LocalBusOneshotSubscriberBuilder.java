package localbus;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author moubin.mo
 * @date: 2020/11/16 20:12
 */

public class LocalBusOneshotSubscriberBuilder implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public LocalBusOneshotSubscriberBuilder() {
	}

	public LocalBusOneshotSubscription build(){
		LocalBusOneshotSubscription subscription = new LocalBusOneshotSubscription();
		this.applicationContext.getAutowireCapableBeanFactory().autowireBean(subscription);
		return subscription;
	}
	public LocalBusOneshotSubscription build(String subject, LocalBusOneshotSubscriber subscriber){
		LocalBusOneshotSubscription subscription = new LocalBusOneshotSubscription();
		this.applicationContext.getAutowireCapableBeanFactory().autowireBean(subscription);
		return subscription.setSubject(subject).setSubscriber(subscriber);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}
}
