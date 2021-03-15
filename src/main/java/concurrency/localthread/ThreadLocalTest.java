package concurrency.localthread;

public class ThreadLocalTest {
	public static void main(String[] args) {
		final ThreadLocal threadLocal = new ThreadLocal();
		threadLocal.set("test");
		System.out.println(threadLocal.get());
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadLocal.set("test hello");
				System.out.println(threadLocal.get());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadLocal.set("test world");
				System.out.println(threadLocal.get());
			}
		}).start();
	}
}
