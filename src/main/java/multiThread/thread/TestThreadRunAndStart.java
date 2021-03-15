package multiThread.thread;

/**
 * @author moubin.mo
 * @date: 2021/1/13 11:59
 */

public class TestThreadRunAndStart {
	public static void main(String[] args) {
		ThreadSyncOrAsyn threadSyncOrAsyn = new ThreadSyncOrAsyn();
		threadSyncOrAsyn.run(); //同步执行
		ThreadSyncOrAsyn threadSyncOrAsyn2 = new ThreadSyncOrAsyn();
		threadSyncOrAsyn2.start();//异步执行
		System.out.println("1111");
	}
}

class ThreadSyncOrAsyn extends Thread {
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ThreadSyncOrAsyn");
	}
}