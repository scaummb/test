package shizhanthread.chapter5.concurrent.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author moubin.mo
 * @date: 2021/2/17 10:29
 */

public class BoundHashSet<T> {
	private final Set<T> set;
	private final Semaphore sem;

	public BoundHashSet(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}

	public boolean add(T o) throws InterruptedException {
		sem.acquire();
		boolean wasAdded = false;

		try {
			wasAdded = set.add(o);
			return wasAdded;
		} finally {
			if (!wasAdded) {
				sem.release();
			}
		}
	}

	public boolean remove(Object o) {
		boolean wasRemoved = set.remove(o);
		if (wasRemoved) {
			sem.release();
		}
		return wasRemoved;
	}
}
