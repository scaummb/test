package multiThread.testAsny;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author moubin.mo
 * @date: 2020/11/4 23:23
 */

public class CallableTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		class MyCallable implements Callable<String> {
			@Override
			public String call() throws Exception {
				return "MyCallable";
			}
		}
		FutureTask<String> task = new FutureTask<>(new MyCallable());
		Thread c = new Thread(task);
		c.start();
		System.out.println(task.get());
	}
}
