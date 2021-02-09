package shizhanthread.chapter5;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *     同步容器类是线程安全的，但某些情况下的复合操作，需要额外的客户端加锁来保证符合操作。
 *     容器复合操作：1.迭代， 2.跳转(Now)，3.条件运算、
 *
 *     同步容器 and 并发容器 是有区别的：并发容器是用来改进同步容器性能的(伸缩性)。
 *     原因：同步容器对容器状态访问进行了串行化，以实现线程安全，但降低了并发性。多线程竞争容器锁，会降低吞吐量。
 * </p>
 */

public class VectorTest {
	private final static Vector vector = new Vector();

	public static Object getlast(Vector vector){
		int lastIndex = vector.size() - 1;
		return vector.get(lastIndex);
	}

	public static void deleteLast(Vector vector){
		int lastIndex = vector.size() - 1;
		vector.remove(lastIndex);
	}

	public static void main(String[] args) {
		vector.add(1L);
		vector.add(2L);
		vector.add(3L);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				getlast(vector);
			}
		};

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				deleteLast(vector);
			}
		};

		Thread thread = new Thread(runnable);
		Thread thread1 = new Thread(runnable1);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(thread);
		executorService.submit(thread1);
	}

}
