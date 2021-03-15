package shizhanthread.chapter4;

import shizhanthread.annotations.ThreadSafe;

import java.util.Vector;

/**
 * <p>
 * 在源码添加拓展代码：
 * 拓展Vector：增加一个“没有则添加”的方法
 * </p>
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
	public synchronized boolean putIfAbct(E x) {
		boolean absent = !contains(x);
		if (absent) {
			add(x);
		}
		return absent;
	}
}
