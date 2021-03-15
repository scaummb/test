package shizhanthread.chapter6;

import sun.misc.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * @author moubin.mo
 * @date: 2021/2/20 20:01
 */

public class LifecycleWebServer {

	private final static ExecutorService exec = Executors.newSingleThreadExecutor();

	public void start() throws IOException {
		ServerSocket socket = new ServerSocket(8800);
		while (!exec.isShutdown()) {
			try {
				Socket connection = socket.accept();
				exec.execute(new Runnable() {
					@Override
					public void run() {
						handleRequest(connection);
					}
				});
			} catch (RejectedExecutionException e) {
				if (exec.isShutdown()) {
					System.out.println("task submission rejected" + e);
				}
			}
		}
	}

	public void stop() {
		exec.shutdown();
	}

	private static void handleRequest(Socket connection) {
		//..
		Request req = readRequest(connection);
		if (isshutdownRequest(req)) {

		}
	}

	private static boolean isshutdownRequest(Request req) {
		return exec.isShutdown();
	}

	private static Request readRequest(Socket connection) {
		return new Request() {
			@Override
			public void execute() {

			}
		};
	}
}
