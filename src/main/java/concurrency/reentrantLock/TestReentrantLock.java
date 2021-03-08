package concurrency.reentrantLock;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moubin.mo
 * @date: 2019/10/10 15:37
 */

public class TestReentrantLock {

	private static final ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		Condition condition = lock.newCondition();
		new HashMap<>();
	}
}
