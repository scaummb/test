package shizhanthread.chapter3;

/**
* <p>可见性测试</p>
 */

public class NoVisibility {
	//非线程安全的状态变量
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread{
		@Override
		public void run() {
			System.out.println("start time = " + System.currentTimeMillis() + " , and number = " + number);
			while (!ready){
				//挂起，让出CPU占用权
				Thread.yield();
			}
			System.out.println(number);
			System.out.println("end time = " + System.currentTimeMillis());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1000);
		number=43;
		ready=true;
		number=100;
		new ReaderThread().start();
		ready=false;
		number=200;
		ready=true;
		number=300;
	}
}
