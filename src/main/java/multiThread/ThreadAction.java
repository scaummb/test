package multiThread;

/**
 * @author moubin.mo
 * @date: 2021/2/19 17:42
 */

public class ThreadAction {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("2");
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("3");
			}
		});

		thread.start();
		thread2.start();
		//把指定的线程加入到当前线程，将交替线程合并为顺序执行，直到该线程“die”
		thread.join();
		thread2.join();
		System.out.println("1");
	}
}
