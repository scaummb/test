package concurrency.ex;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * <p>
 * 而在线程池中，该如何批量的为所有线程设置UncaughtExceptionHandler呢？
 *
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/3/8 08:12
 */

public class TestBatchEx {

	public static void main(String[] args) {
		try {
			//1、设置了未捕获异常的处理
//			ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new CustomExceptionThreadFactory());
			//2、没设置未捕获异常的处理
			ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
			//3、默认线程池创建，不设置未捕获异常的处理
//			ExecutorService executor=Executors.newFixedThreadPool(6);
			ArrayList<Future<Object>> futures = new ArrayList<>();
			Future<Object> future = (Future<Object>) executor.submit(new Callable<Object>() {
				@Override
				public Object call() {
					//抛出异常
					throw new RuntimeException();
				}
			});
			futures.add(future);

			//遍历Future获取到子线程的异常
			for (Future<Object> back : futures) {
				try {
					Object o = back.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println(e.toString() + "===========================");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
