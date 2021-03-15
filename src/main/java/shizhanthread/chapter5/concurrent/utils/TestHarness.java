package shizhanthread.chapter5.concurrent.utils;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 闭锁实现之一：CountDownLatch
 * </p>
 */

public class TestHarness {
	public static void main(String[] args) throws InterruptedException {
		timeTasks(10, new Runnable() {
			@Override
			public void run() {
				System.out.println("hhhhha..");
			}
		});
	}

	public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			//启动多个异步线程
			Thread thread = new Thread() {
				public void run() {
					try {
						//启动门阻塞
						startGate.await();
						try {
							task.run();
						} finally {
							//结束门-1
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
		}

		long start = System.nanoTime();
		//启动门-1
		startGate.countDown();
		//结束门
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}
}
