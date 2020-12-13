package shizhanthread.chapter2;

import shizhanthread.annotations.ThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/12/13 17:56
 */
@ThreadSafe
public class SynchronizedInteger {
	private int value;

	public synchronized int getValue() {
		return this.value;
	}

	public synchronized void setValue(final int value) {
		this.value = value;
	}
}
