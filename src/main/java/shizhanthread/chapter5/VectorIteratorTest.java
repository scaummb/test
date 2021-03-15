package shizhanthread.chapter5;

import java.util.Vector;

/**
 * <p>
 * 容器复合操作：1.迭代(Now)， 2.跳转，3.条件运算
 * </p>
 */

public class VectorIteratorTest {
	private final static Vector vector = new Vector();

	public void exceptionOperation() {
		//ArrayIndexOutOfBoundsException maybe be throws.
		for (int i = 0; i < vector.size(); i++) {
			dosomething(vector.get(i));
		}
	}

	private void dosomething(Object o) {
		//...
	}

	//客户端加锁
	public void atomicOperation() {
		synchronized (vector) {
			for (int i = 0; i < vector.size(); i++) {
				dosomething(vector.get(i));
			}
		}
	}
}
