package shizhanthread.chapter6;

import java.util.concurrent.*;

/**
 * @author moubin.mo
 * @date: 2021/2/20 20:43
 */

public class TestTaskTimeoutException {
	private static final long TIME_BUDGET = 1000000;
	private static final ExecutorService exec = Executors.newSingleThreadExecutor();
	private static final Ad DEFAULT_AD = new Ad("default ad");

	Page renderPageWithAd(){
		long endNanos = System.nanoTime() + TIME_BUDGET;
		Future<Ad> future = exec.submit(new FetchAdTask());
		Page page = renderPageBody();
		Ad ad = null;
		try {
			long timeLeft = endNanos - System.nanoTime();
			ad = future.get(timeLeft, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			ad = DEFAULT_AD;
		} catch (ExecutionException e) {
			ad = DEFAULT_AD;
		} catch (TimeoutException e) {
			ad = DEFAULT_AD;
			//假如正在执行，可以中断任务执行
			future.cancel(true);
		}
		page.setAd(ad);
		return page;
	}

	private Page renderPageBody() {
		return new Page();
	}
	class Page{
		private Ad ad;
		public Ad getAd() {
			return this.ad;
		}
		public void setAd(final Ad ad) {
			this.ad = ad;
		}
	}
	static class Ad{
		private String name;
		public Ad(final String name) {
			this.name = name;
		}
	}
	class FetchAdTask implements Callable{
		@Override
		public Ad call() throws Exception {
			return new Ad("finish");
		}
	}
}
