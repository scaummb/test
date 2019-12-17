package leetCode.middle;

import java.util.function.IntConsumer;

/**
 * 使用线程休眠与唤醒解决线程执行调度
 * @author moubin.mo
 * @date: 2019/11/21 20:43
 */

public class ZeroEvenOddV2 {
	private int n;
	private volatile boolean zeroFlag = false;
	private volatile boolean flag;

	public ZeroEvenOddV2(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		synchronized (this){
			for (int i=1; i<=n; i++){
				while (zeroFlag){
					this.wait();
				};
				printNumber.accept(0);
				if (n%2 == 0){
					flag = true;
				} else {
					flag = false;
				}
				zeroFlag = true;
				notifyAll();
			}
		}
	}

	/**
	 * 输出偶数
	 */
	public void even(IntConsumer printNumber) throws InterruptedException {
		synchronized (this){
			for (int i=2; i<=n; i+=2){
				while (!flag){
					this.wait();
				}
				printNumber.accept(i);
				zeroFlag = false;
				notifyAll();
			}

		}
	}

	/**
	 * 输出奇数
	 */
	public void odd(IntConsumer printNumber) throws InterruptedException {
		synchronized (this){
			for (int i=1; i<=n; i+=2){
				while (flag){
					this.wait();
				}
				printNumber.accept(i);
				zeroFlag = false;
				notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		ZeroEvenOddV2 zeroEvenOdd = new ZeroEvenOddV2(2);

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
					zeroEvenOdd.even(num ->{
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
