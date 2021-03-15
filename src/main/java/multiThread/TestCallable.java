package multiThread;

import java.util.concurrent.*;

/**
 * @author moubin.mo
 * @date: 2019/11/28 11:23
 */

public class TestCallable {
	private static ExecutorService pools = Executors.newFixedThreadPool(1);

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		StringBuffer stringBuffer = new StringBuffer();
		Future<String> submit = pools.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "test";
			}
		});
		stringBuffer.append(submit.get());
		System.out.print(stringBuffer);
	}
}
