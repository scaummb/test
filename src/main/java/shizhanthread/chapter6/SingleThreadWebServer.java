package shizhanthread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * 性能差，串行web服务器
 * 带来【较差的性能和吞吐量】
 * </p>
 */

public class SingleThreadWebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(8800);
		while (true) {
			Socket connection = socket.accept();
			handleRequest(connection);
		}
	}

	private static void handleRequest(Socket connection) {
		//..
	}
}
