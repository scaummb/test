package shizhanthread.chapter8.queuetest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author moubin.mo
 * @date: 2021/2/22 11:13
 */

public class SynchronousQueueDemo {
	private static BlockingQueue<String> synchronousQueue = new SynchronousQueue();
	private static Runnable runnable1 = () -> {
		System.out.println(Thread.currentThread().getName() + ":put thread start");
		try {
			synchronousQueue.put("value1");
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ":put thread end");
	};

	private static Runnable runnable2 = () -> {
		System.out.println(Thread.currentThread().getName() + ":take thread start");
		try {
			System.out.println(Thread.currentThread().getName() + ":take value ->" + synchronousQueue.take());
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ":take thread end");
	};

	public static void main(String[] args) throws InterruptedException {
		Thread putThread1 = new Thread(runnable1, "putThread1");
		Thread putThread2 = new Thread(runnable1, "putThread2");
		Thread takeThread1 = new Thread(runnable2, "takeThread1");
		putThread1.start();
		Thread.sleep(1000);
		putThread2.start();
		Thread.sleep(1000);
		System.out.println("2 put thread is blocking...");
		takeThread1.start();
	}
}