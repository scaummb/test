package concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author moubin.mo
 * @date: 2021/2/22 11:11
 */

public class ThreadPool {
	public static void main(String[] args) throws InterruptedException {
//		test1();
//		test2();
//		test3();
		test4();
		test15();
	}

	private static void test15() {
		//可以延期执行或者周期执行
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
		//工作线程数量，基本大小=1，最大大小=1,FIFO
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		//线程池的工作线程数量是无界的,默认存活时间60s，超过会被kill掉,默认没有拒绝策略
		ExecutorService executorService3 = Executors.newCachedThreadPool();
		//线程池的工作线程数量基础大小 = 数量最大值; 拒绝策略是超过了基础数据，则会抛异常 RejectedExecutionException。
		//线程存活时间，0，不会出现多余工作线程,自定义：线程工厂
		ExecutorService executorService4 = Executors.newFixedThreadPool(10);
		//单线程调度执行任务
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	}


	private static void test5() {
		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		pool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("123123");
			}
		}, 0, TimeUnit.SECONDS);
	}

	private static void test4() {
		//可以延期执行或者周期执行
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
		for (int i = 0; i <= 10000; i++) {
			int finalI = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(finalI);
				}
			});
		}
	}

	private static void test3() {
		//工作线程数量，基本大小=1，最大大小=1,FIFO
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i <= 10000; i++) {
			int finalI = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(finalI);
				}
			});
		}
	}

	private static void test2() {
		//线程池的工作线程数量是无界的,默认存活时间60s，超过会被kill掉,默认没有拒绝策略
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i <= 10000; i++) {
			int finalI = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(finalI);
				}
			});
		}
	}

	private static void test1() throws InterruptedException {
		//线程池的工作线程数量基础大小 = 数量最大值; 拒绝策略是超过了基础数据，则会抛异常 RejectedExecutionException。
		//线程存活时间，0，不会出现多余工作线程,自定义：线程工厂
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i <= 10000; i++) {
			int finalI = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(finalI);
				}
			});
		}
	}
}
