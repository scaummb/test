package leetCode.muilt_thread;

/**
 * @author moubin.mo
 * @date: 2019/11/19 09:17
 */

class FooBar {
	private int n;
	private static Object lock = new Object();
	private static volatile Boolean flag = true;
	//here is the full path, or maybe cann't compile in leetcode.
	java.util.concurrent.Semaphore semaphoreFoo = new java.util.concurrent.Semaphore(0);
	java.util.concurrent.Semaphore semaphoreBar = new java.util.concurrent.Semaphore(0);

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (lock) {
				if (!flag) {
					lock.wait();
				}
				// printBar.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				flag = false;
				lock.notify();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			synchronized (lock) {
				if (flag) {
					lock.wait();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				flag = true;
				lock.notify();
			}
		}
	}


	public void foo2(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			// printBar.run() outputs "foo". Do not change or remove this line.
			printFoo.run();
			semaphoreBar.release();
			semaphoreFoo.acquire();

		}
	}

	public void bar2(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			// printBar.run() outputs "bar". Do not change or remove this line.
			printBar.run();
			semaphoreFoo.release();
			semaphoreBar.acquire();
		}
	}

	public static void main(String[] args) {
		FooBar fooBar = new FooBar(20);
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.foo2(new Runnable() {
						@Override
						public void run() {
							System.out.print("foo");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.bar2(new Runnable() {
						@Override
						public void run() {
							System.out.print("bar");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread1 = new Thread(runnable1);
		thread1.start();
		Thread thread2 = new Thread(runnable2);
		thread2.start();
	}
}