package threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * REMARK 线程池 newCachedThreadPool
 *
 * @author: mmb
 * @date: 19-11-3
 */
@Slf4j
public class TestThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
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
