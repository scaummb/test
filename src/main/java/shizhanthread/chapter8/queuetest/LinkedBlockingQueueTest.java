package shizhanthread.chapter8.queuetest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * LinkedBlockingQueue 剖析 {@link  java.util.concurrent.LinkedBlockingQueue}
 * <p>
 * LinkedBlockingQueue ,有头尾两个指针。
 * 本身是个线程安全的类。
 * 实现了Queue：offer》add（添加尾元素），
 * poll》remove（获取头元素并删除），
 * peek>element（头元素获取不删除），后面的都会抛异常。
 * 都有两个锁（take锁&put锁）
 *
 * </p>
 */

public class LinkedBlockingQueueTest {
	public static void main(String[] args) {
		testOperations();
	}

	private static void testOperations() {
		BlockingQueue queue = new LinkedBlockingQueue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.peek());
	}
}
