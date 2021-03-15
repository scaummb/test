package leetCode.middle;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 错在哪里知道了吗？这是因为线程直接跑一次就没了，缺少轮询和线程间通信！
 * 凡是可以用信号量解决的问题，都可以用管程模型来解决!
 *
 * @author moubin.mo
 * @date: 2019/11/21 20:43
 */

public class ZeroEvenOdd {
	private int n;
	private static Semaphore z = new Semaphore(1);
	private static Semaphore e = new Semaphore(0);
	private static Semaphore o = new Semaphore(0);

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			z.acquire();
			printNumber.accept(0);
			if ((i & 1) == 0) {
				e.release();
			} else {
				o.release();
			}
		}
	}

	/**
	 * 输出偶数
	 */
	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			e.acquire();
			printNumber.accept(i);
			z.release();
		}
	}

	/**
	 * 输出奇数
	 */
	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			o.acquire();
			printNumber.accept(i);
			z.release();
		}
	}

	public static void main(String[] args) {
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.zero(e -> System.out.print(e));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.even(num -> {
						System.out.print(num);
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnable3 = new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.even(num -> {
						System.out.print(num);
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		Thread thread3 = new Thread(runnable3);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
