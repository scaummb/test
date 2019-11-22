package leetCode.muilt_thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author moubin.mo
 * @date: 2019/11/18 09:10
 */

class FizzBuzz {
	private int n;
	private Object lock = new Object();
	AtomicInteger count = new AtomicInteger(1);

	public FizzBuzz(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (count.get() <= n){
			synchronized (lock){
				if (count.get() <= n && count.get() % 3 == 0 && count.get() % 5 != 0){
					printFizz.run();
					count.incrementAndGet();
				}
			}

		}

	}

	// printBuzz.run() outputs "buzz".
	// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (count.get() <= n){
			synchronized (lock){
				if (count.get() <= n && count.get() % 5 == 0 && count.get() % 3 != 0){
					printBuzz.run();
					count.incrementAndGet();
				}
			}
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (count.get() <= n){
			synchronized (lock){
				if (count.get() <= n && (count.get() % 5 == 0 && count.get() % 3 == 0)){
					printFizzBuzz.run();
					count.incrementAndGet();
				}
			}
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
	public void number(IntConsumer printNumber) throws InterruptedException {
		while (count.get() <= n){
			synchronized (lock){
				if (count.get() <= n && (count.get() % 5 != 0 && count.get() % 3 != 0)){
					printNumber.accept(count.get());
					count.incrementAndGet();
				}
			}
		}
	}
}