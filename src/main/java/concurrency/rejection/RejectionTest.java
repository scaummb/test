package concurrency.rejection;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author moubin.mo
 * @date: 2021/3/9 16:26
 */

public class RejectionTest {
	// 核心线程数（为了模拟看效果设置小一点）
	private static final int corePoolSize = 2;
	// 最大线程数（为了模拟看效果设置小一点）
	private static final int maximumPoolSize = 5;
	// 线程空闲下来后，存活的时间（ms）
	private static final int keepalivetime = 1;
	private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepalivetime, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadRejectionExecutionHandler());

	public static void main(String[] args) {
		for (int i = 1; i < 20; i++){
			pool.execute(new Worker("i"));
		}
		pool.shutdown();
	}
}
