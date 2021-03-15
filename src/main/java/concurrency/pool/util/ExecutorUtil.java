package concurrency.pool.util;

import multiThread.thread.ThreadUtil;

import java.util.concurrent.*;

/**
 * 线程池,任务调度工具类
 *
 */
public final class ExecutorUtil {
    /**
     * 线程池
     */
    private static ExecutorService threadpool = ThreadUtil.newExecutorService(5, 150, 150, 1800, "content-cloud-exe");


    /**
     * 执行任务
     * @param task - 任务
     * @return - 执行期望值
     */
    public static Future<?> submit(Runnable task) {
  return threadpool.submit(task); 
 }
}