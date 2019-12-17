package multiThread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author moubin.mo
 * @date: 2019/12/13 15:49
 */

public class Test {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Future<String> submit = ExecutorUtil.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "String";
			}
		});
		System.out.print(submit.get());
	}
}
