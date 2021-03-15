package shizhanthread.chapter4;

import org.apache.poi.ss.formula.functions.T;
import shizhanthread.annotations.NotThreadSafe;
import shizhanthread.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 客户端加锁机制：
 * 在使用的地方加锁。
 * </p>
 */

public class ListHelper {
	public List list = Collections.synchronizedList(new ArrayList());

	//线程不安全，因为这里锁住的不是list对象，而是使用了对象的内置锁！！造成了线程安全的假象。
	@NotThreadSafe
	public synchronized boolean putIfAbsent(T x) {
		boolean absent = list.contains(x);
		if (absent) {
			list.add(x);
		}
		return absent;
	}

	@ThreadSafe
	public boolean putIfAbsentSafely(T x) {
		//线程安全，这里锁住的是list对象。【客户端加锁实现】
		synchronized (list) {
			boolean absent = list.contains(x);
			if (absent) {
				list.add(x);
			}
			return absent;
		}
	}

}
