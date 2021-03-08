package concurrency.ex;

import java.util.concurrent.ThreadFactory;

/**
 * <p>
 *     要自定义处理异常，只需要为线程提供一个自定义的UncaughtExceptionHandler。而在线程池中，该如何批量的为所有线程设置UncaughtExceptionHandler呢？
 *     我们知道，线程池中的线程是由线程工厂创建的。我们可以跟踪ThreadPoolExecutor构造方法的源码，
 *     最终定位到 DefaultThreadFactory 类，该类中有个newThread()方法，这就是线程产生的源头了
 * </p>
 * @author moubin.mo
 * @date: 2021/3/8 08:17
 */

public class CustomExceptionThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread();
		thread.setUncaughtExceptionHandler(new CustomExceptionHandler());
		return thread;
	}
}
