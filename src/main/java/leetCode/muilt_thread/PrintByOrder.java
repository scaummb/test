package leetCode.muilt_thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1114. 按序打印
 *
 * @author moubin.mo
 * @date: 2019/11/15 12:20
 */

public class PrintByOrder {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Foo foo = new Foo();

		Runnable runnableA = new Runnable() {
			@Override
			public void run() {
				try {
					foo.first(new Runnable() {
						@Override
						public void run() {
							System.out.print("first");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnableB = new Runnable() {
			@Override
			public void run() {
				try {
					foo.second(new Runnable() {
						@Override
						public void run() {
							System.out.print("two");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable runnableC = new Runnable() {
			@Override
			public void run() {
				try {
					foo.third(new Runnable() {
						@Override
						public void run() {
							System.out.print("three");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		executorService.submit(runnableA);
		executorService.submit(runnableB);
		executorService.submit(runnableC);
	}

}

class Foo {
	private final static CountDownLatch countDownLatchTwo = new CountDownLatch(1);
	private final static CountDownLatch countDownLatchThree = new CountDownLatch(1);

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		countDownLatchTwo.countDown();
	}

	public void second(Runnable printSecond) throws InterruptedException {

		// printSecond.run() outputs "second". Do not change or remove this line.
		countDownLatchTwo.await();
		printSecond.run();
		countDownLatchThree.countDown();
	}

	public void third(Runnable printThird) throws InterruptedException {

		// printThird.run() outputs "third". Do not change or remove this line.
		countDownLatchThree.await();
		printThird.run();
	}
}