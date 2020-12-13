package shizhanthread.chapter3;

import shizhanthread.annotations.NotThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/12/13 17:55
 */
@NotThreadSafe
public class MutablInteger {
	private int value;

	public int getValue() {
		return this.value;
	}

	public void setValue(final int value) {
		this.value = value;
	}
}
