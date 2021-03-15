package shizhanthread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * 优化串行web服务：为每个请求启动一个新线程（）
 * 虽然将任务跟主线程分离了，响应性提高了。
 * 但处理任务代码必须线程安全，因为并发执行。
 * <p>
 * 但是存在致命缺陷【带来资源管理复杂性】
 * 1、线程开销巨大（线程模型-用户线程-》内核线程-时间和操作系统辅助开销大）
 * 2、资源消耗（大量空余线程占用很多内存）
 * 3、突破JVM限制
 * </p>
 */

public class ThreadPerTaskWebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8800);
		while (true) {
			Socket connection = socket.accept();
			//创建新的线程
			Runnable task = new Runnable() {
				@Override
				public void run() {
					handleRequest(connection);
				}
			};
			new Thread(task).start();
		}
	}

	private static void handleRequest(Socket connection) {
		//..
	}
}
