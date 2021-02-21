package shizhanthread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>
 *     通过使用Executor，将请求提交 和 请求处理 解耦。
 *     考虑用Executor代替Thread。
 * </p>
 */

public class TaskExecutionWebServer {
	private static final int NTHREADS = 100;

	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8080);
		while (true){
			Socket connection = socket.accept();
			//创建新的线程
			Runnable task = new Runnable() {
				@Override
				public void run() {
					handleRequest(connection);
				}
			};
			exec.execute(task);
		}
	}

	private static void handleRequest(Socket connection) {
	}
}
