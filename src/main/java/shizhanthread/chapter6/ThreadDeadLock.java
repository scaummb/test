package shizhanthread.chapter6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author moubin.mo
 * @date: 2021/2/20 22:12
 */

public class ThreadDeadLock {

	private final static ExecutorService exec =  Executors.newSingleThreadExecutor();

	public class RenderPageTank implements Callable<String>{
		@Override
		public String call() throws Exception {
			Future<String> header = null, footer = null;
			exec.submit(new LoadFileTask("header.html"));
			exec.submit(new LoadFileTask("footer.html"));
			Page page = renderBody();
			//死锁：任务在等待
			return header.get() + page + footer.get();
		}

		private Page renderBody() {
			//do some thing
			return new Page();
		}
	}
	class Page{}
	class LoadFileTask implements Callable<String>{

		private String name;

		public LoadFileTask(final String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			return null;
		}
	}
}
