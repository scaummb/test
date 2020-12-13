package shizhanthread.chapter3;

/**
 * @author moubin.mo
 * @date: 2020/12/13 18:42
 */

public class CountSheeps {
	static volatile boolean asleep;
	public static void main(String[] args) throws InterruptedException {
		new CountSheepsThread().start();
		Thread.sleep(10000);
		asleep = true;
	}
	private static class CountSheepsThread extends Thread{
		@Override
		public void run() {
			while (!asleep)
				Thread.yield();
			countSheep();
		}
		private void countSheep() {
			System.out.println("zzz...");
		}
	}

}
