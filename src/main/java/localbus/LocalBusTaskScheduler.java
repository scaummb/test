package localbus;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author moubin.mo
 * @date: 2020/11/16 20:21
 */

public class LocalBusTaskScheduler {
	private static final int DEFAULT_POOL_SIZE = 5;
	private TaskScheduler scheduler = new ThreadPoolTaskScheduler();

	public LocalBusTaskScheduler(TaskScheduler scheduler) {
		((ThreadPoolTaskScheduler)this.scheduler).setPoolSize(5);
		((ThreadPoolTaskScheduler)this.scheduler).afterPropertiesSet();
	}

	public TaskScheduler getScheduler() {
		return scheduler;
	}
}
