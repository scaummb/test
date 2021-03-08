package concurrency.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *		1.阿里规约：创建一个 ThreadPoolExecutor 更利于同时知道其中的运行规则
 * </p>
 */

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		//1、应该提倡使用ThreadPoolExecutor直接构造线程池，而非利用Executors工具类
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

		//ArrayBlockingQueue & LinkedBlockingQueue，一个数组，一个链表实现


	}
}
