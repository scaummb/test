package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;

/**
 * <p>
 * 实例封闭之二：
 * 通过一个私有锁来保护状态
 * </p>
 */
@ThreadSafe
public class PrivateLock {
	private final Object myLock = new Object();
	Widget widget;

	void someMethod() {
		synchronized (myLock) {
			//访问或修改Widget的状态
		}
	}

	class Widget {
	}
}
