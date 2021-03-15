package leetCode.middle.multithread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * REMARK
 *
 * @author: mmb
 * @date: 19-11-19
 */
class FooBar {
	private int n;
	private static volatile AtomicBoolean flag = new AtomicBoolean(false);
	private static Object object = new Object();

	public static void main(String[] args) {
		FooBar fooBar = new FooBar(5);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.foo(new Runnable() {
						@Override
						public void run() {
							System.out.print("foo");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					fooBar.bar(new Runnable() {
						@Override
						public void run() {
							System.out.print("bar");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		thread2.start();
	}

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; ) {
//            synchronized (object){
			if (!flag.get()) {
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				flag.set(true);
				i++;
			}

//            }
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; ) {
//            synchronized (object){
			if (flag.get()) {
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				flag.set(false);
				i++;
			}

//            }
		}
	}
}