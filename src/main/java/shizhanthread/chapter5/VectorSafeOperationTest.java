package shizhanthread.chapter5;

import java.util.Vector;

/**
 * <p>
 *     客户端加锁，使得 getlast & deleteLast 成为原子操作。
 *     容器复合操作：1.迭代， 2.跳转(Now)，3.条件运算
 * </p>
 */

public class VectorSafeOperationTest {
	private final static Vector vector = new Vector();

	public static Object getlast(Vector vector){
		synchronized (vector){
			int lastIndex = vector.size() - 1;
			return vector.get(lastIndex);
		}
	}

	public static void deleteLast(Vector vector){
		synchronized (vector){
			int lastIndex = vector.size() - 1;
			vector.remove(lastIndex);
		}
	}

}
