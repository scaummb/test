package threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * REMARK 线程池 newScheduledThreadPool
 *
 * @author: mmb
 * @date: 19-11-3
 */
@Slf4j
public class TestThreadPool3 {
	public static void main(String[] args) {
		// 有界的任务队列，线程池
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 10; i++) {
			final int index = i;
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("runnable, i = " + index);
//                }
//            });

			// schedule 延时执行
			executorService.schedule(new Runnable() {
				@Override
				public void run() {
					System.out.println("runnable, i = " + index);
				}
			}, 2, TimeUnit.SECONDS);

		}

		// scheduleAtFixedRate 延时 1s + 每隔 1s周期执行
		executorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("schedule, ");
			}
		}, 1, 1, TimeUnit.SECONDS);

//        executorService.shutdown();
	}
}
