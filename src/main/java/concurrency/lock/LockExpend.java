package concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moubin.mo
 * @date: 2021/3/11 10:20
 */

public class LockExpend {
	private final static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		int[] ints = new int[10];
		for (int i : ints){
			lock.lock();
			try {
				// do something..
				System.out.println(i);
			} finally {
				lock.unlock();
			}
		}
	}
}
