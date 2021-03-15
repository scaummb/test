package multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author moubin.mo
 * @date: 2019/11/18 19:27
 */

public class TestThread {
	public static void main(String[] args) {
		TestThreadDemo testThreadDemo = new TestThreadDemo();
		testThreadDemo.run();
		testThreadDemo.start();

		ExecutorService executorService = Executors.newFixedThreadPool(11);
		executorService.submit(new TestRunnableDemo());
		executorService.submit(new TestCallableDemo());
		executorService.shutdown();

		MyThread myThread = new MyThread();
		myThread.start();
		myThread.run();
	}

	public static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("MyThread run...");
		}
	}
}

class TestThreadDemo extends Thread {
	@Override
	public void run() {
		System.out.println("TestThreadDemo");
	}
}

class TestRunnableDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("TestRunnableDemo");
	}
}

class TestCallableDemo implements Callable {

	@Override
	public String call() throws Exception {
		System.out.println("TestCallableDemo");
		return "TestCallableDemo OK";
	}
}
