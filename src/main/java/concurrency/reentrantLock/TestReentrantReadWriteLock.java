package concurrency.reentrantLock;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * remark:ReentrantReadWriteLock 测试
 *
 * @author moubin.mo
 * @date: 2019/10/10 15:01
 */

public class TestReentrantReadWriteLock {
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();

	private final Map<String, Data> map = new TreeMap<>();

	public Data get(String key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public Set<String> getAllKeys() {
		readLock.lock();
		try {
			return map.keySet();
		} finally {
			readLock.unlock();
		}
	}

	public Data put(String key, Data value) {
		writeLock.lock();
		try {
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {

	}
}
