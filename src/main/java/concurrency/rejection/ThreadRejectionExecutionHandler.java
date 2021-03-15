package concurrency.rejection;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 自定义拒绝策略：重新放入线程池
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/3/9 16:22
 */

public class ThreadRejectionExecutionHandler implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		try {
			Worker worker = (Worker) r;
			// 模拟写日志
			System.out.println(worker.getId() + " 被丢弃！");
			executor.getQueue().put(worker);
//			executor.submit(worker);
		} catch (InterruptedException e) {
			// 异常发生后打印
			System.out.println("ThreadRejectionExecutionHandler：info = " + r.toString());
		}
	}
}
