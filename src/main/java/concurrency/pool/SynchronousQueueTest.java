package concurrency.pool;

import java.util.concurrent.SynchronousQueue;

/**
 * <p>
 *     SynchronousQueue 内部没有容器，一个生产线程，当它生产产品（put），如果没有人想要消费（take）
 *
 * </p>
 * @author moubin.mo
 * @date: 2021/3/9 12:51
 */

public class SynchronousQueueTest {
	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<Integer> queue = new SynchronousQueue<>();

		//producer
		Thread putThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("put thread start..");
				try {
					//put 操作会一直阻塞，知道有消费者来取出数据
					queue.put(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("put thread end.");
			}
		});

		//consumer
		Thread takeThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("take thread start..");
				try {
					System.out.println("take from putThread: " + queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("take thread end.");
			}
		});

		putThread.start();
		Thread.sleep(1000);
		takeThread.start();
	}
}
