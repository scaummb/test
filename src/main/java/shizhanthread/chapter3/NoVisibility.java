package shizhanthread.chapter3;

/**
 * <p>可见性测试</p>
 */
public class NoVisibility {
	//非线程安全的状态变量
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			while (!ready)
				//挂起，让出CPU占用权
				Thread.yield();
			System.out.println("ready = " + ready + " , and number = " + number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		number = 43;
		ready = true;
	}
}
