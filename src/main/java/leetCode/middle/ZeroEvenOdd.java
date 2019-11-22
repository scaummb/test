package leetCode.middle;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 错在哪里知道了吗？这是因为线程直接跑一次就没了，缺少轮询和线程间通信！
 * @author moubin.mo
 * @date: 2019/11/21 20:43
 */

public class ZeroEvenOdd {
	private int n;
	private static volatile Integer num = 0;
	private static Semaphore semaphoreA = new Semaphore(1);
	private static Semaphore semaphoreB = new Semaphore(1);
	private static Semaphore semaphoreC = new Semaphore(1);

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i=0; i<n; i++){

		}
		semaphoreA.acquire();
		if (num <= n+1){
			printNumber.accept(0);
			num++;
		}
		semaphoreB.release();
		semaphoreC.release();
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		semaphoreB.acquire();
		if (num <= n){
			printNumber.accept(num);
		}
		semaphoreA.release();
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		semaphoreC.acquire();
		if (num <= n){
			printNumber.accept(num);
		}
		semaphoreA.release();
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
					zeroEvenOdd.even(num ->{
						if (num % 2 == 0){
							System.out.print(num);
						}
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
					zeroEvenOdd.even(num ->{
						if (num % 2 != 0){
							System.out.print(num);
						}
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
