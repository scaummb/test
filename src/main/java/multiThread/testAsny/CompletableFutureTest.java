package multiThread.testAsny;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @author moubin.mo
 * @date: 2020/11/4 23:17
 */

public class CompletableFutureTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		// JDK1.8 提供的 CompletableFuture
		CompletableFuture<String> futureTask = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				System.out.println("task start");
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
					e.printStackTrace();
					return "execute failure";
				}
				System.out.println("task end");
				return "execute success";
			}
		}, threadPool);
		// 异步获取 futureTask 的执行结果，此处代码可以跟其他流程代码放在一起
		futureTask.thenAccept(e -> System.out.println("future task result:" + e));
		System.out.println("main thread end");
	}
}
