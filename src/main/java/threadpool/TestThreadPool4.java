package threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * REMARK 线程池 newFixedThreadPool
 *
 * @author: mmb
 * @date: 19-11-3
 */
@Slf4j
public class TestThreadPool4 {
	public static void main(String[] args) {
		// 有界的任务队列，线程池
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("runnable, i = " + index);
				}
			});
		}
		executorService.shutdown();
	}
}
