package concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author moubin.mo
 * @date: 2021/2/22 11:11
 */

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ExecutorService executorService1 = Executors.newCachedThreadPool();
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
	}
}
