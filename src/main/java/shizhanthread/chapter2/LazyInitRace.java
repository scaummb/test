package shizhanthread.chapter2;

import shizhanthread.annotations.NotThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/11/29 22:41
 */
@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;

	public ExpensiveObject getInstance() {
		if (instance == null) {
			instance = new ExpensiveObject();
		}
		return instance;
	}
}

class ExpensiveObject {
}