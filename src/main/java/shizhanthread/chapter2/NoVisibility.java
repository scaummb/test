package shizhanthread.chapter2;

/**
 * @author moubin.mo
 * @date: 2020/11/27 00:05
 */

public class NoVisibility {
	// ready 和 number 对其他线程来说，所有修改都是不可见，因此当被Thread1读取时，值就加载到另一个线程的内部空间了（Thread1的读取都是针对自己内存的对象），后续其他Thread2修改了这里的
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			while (true) {
				if (!ready) {
					try {
						Thread.sleep(2000);
						System.out.println("ReaderThread , no ready, ready= " + ready + ", number= " + number);
						number = 10;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ReaderThread, ready, ready= " + ready + ", number= " + number);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					number = 1;
				}
			}
		}
	}

	private static class ReaderThread2 extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				number = 1000;
				ready = true;
				while (true) {
					System.out.println("main, ready= " + ready + ", number= " + number);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().run();
		new ReaderThread2().run();
	}
}
