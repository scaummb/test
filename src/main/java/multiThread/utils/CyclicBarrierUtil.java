package multiThread.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 *     栅栏，初始化等待唤醒的线程数量。时机成熟（await数量足够，会一次性唤醒所有阻塞线程执行）
 *     计算完成之后，重新恢复到预设值并且开始阻塞请求。
 *
 *     CyclicBarrier可以在构造时指定需要在屏障前执行await的个数，所有对await的调用都会等待，
 *		 直到调用await的次数达到预定指，所有等待都会立即被唤醒
 *
 *     cyclicBarrier.getNumberWaiting() = 获取正在等待的线程数量
 *     cyclicBarrier.getParties() = 一共需要多少等待线程数量
 *
 *   重点在于被阻塞的线程们。CyclicBarrier是让多个线程互相等待某一事件的发生，然后同时被唤醒。
 *
 *	内部维护了唯一一把可重入锁 lock（读写锁），ReentenceLock 内部 维护了一个 Sync （AbstractQueuedSynchronizer）
 *
 * </p>
 * @author moubin.mo
 * @date: 2021/3/1 11:00
 */
public class CyclicBarrierUtil {
	public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cyclicBarrier.await();
					System.out.println("111111");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cyclicBarrier.await();
					System.out.println("222222");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}).start();
		cyclicBarrier.await();
		System.out.println("3333333");

		System.out.println(cyclicBarrier.getNumberWaiting());
		System.out.println(cyclicBarrier.getParties());
	}
}
