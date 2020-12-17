package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;

/**
 * <p>
 *     使用Java监视器模式的线程安全计数器,使用对象内置锁
 * </p>
 *
 */
@ThreadSafe
public final class Counter {
	private long valule = 0;

	public synchronized long getValule() {
		return valule;
	}

	public synchronized void setValule(long valule) {
		if (valule == Long.MAX_VALUE)
			throw new IllegalStateException("counter overflow");
		this.valule = valule;
	}
}
