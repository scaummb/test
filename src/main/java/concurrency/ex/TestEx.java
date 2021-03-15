package concurrency.ex;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 一个异常被抛出后，如果没有被捕获处理，则会一直向上抛。异常一旦被Thread.run() 抛出后，就不能在程序中对异常进行捕获，最终只能由JVM捕获。
 * JVM的这种设计源自于这样一种理念：“线程是独立执行的代码片断，线程的问题应该由线程自己来解决，而不要委托到外部。”基于这样的设计理念，在Java中，线程方法的异常（无论是checked还是unchecked exception），都应该在线程代码边界之内（run方法内）进行try catch并处理掉。换句话说，我们不能捕获从线程中逃逸的异常。
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/3/7 22:12
 */

public class TestEx {
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

		try {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					throw new NullPointerException();
				}
			});
			//设置子线程的异常处理Handler(未捕获异常处理器来处理异常)
//			thread.setUncaughtExceptionHandler(new CustomExceptionHandler());
			thread.setName("subThread");
			thread.start();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
