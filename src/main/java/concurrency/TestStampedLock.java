package concurrency;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock，由版本（stamp）和模式（共3种）组成
 *
 * @author moubin.mo
 * @date: 2019/10/10 15:18
 */

public class TestStampedLock {
	private final static Long threadTotal = 5000L;
	private final static Long concurrencyNum = 200L;
	private static final StampedLock lock = new StampedLock();
	private static Long count = 0L;

	public static void add() {
		long stamp = lock.writeLock();
		try {
			count++;
		} finally {
			lock.unlockWrite(stamp);
		}
	}

	public static void main(String[] args) {

	}
}
