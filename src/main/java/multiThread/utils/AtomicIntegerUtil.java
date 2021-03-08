package multiThread.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *      private volatile int value; //内部维护了一个value，可见性，禁止重排序
 *      CAS，确保操作原子性
 *
 * </p>
 * @author moubin.mo
 * @date: 2021/3/1 12:05
 */

public class AtomicIntegerUtil {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.getAndSet(11);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("1111");
				atomicInteger.getAndSet(1111);
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("2222");
				atomicInteger.getAndSet(2222);
			}
		}).start();

		System.out.println(atomicInteger.incrementAndGet());
	}
}
