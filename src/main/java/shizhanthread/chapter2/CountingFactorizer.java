package shizhanthread.chapter2;

import shizhanthread.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author moubin.mo
 * @date: 2020/11/29 22:47
 */
@ThreadSafe
public class CountingFactorizer extends BaseClass implements Servlet {

	private final AtomicLong count = new AtomicLong();

	public AtomicLong getCount() {
		return count;
	}

	@Override
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
		//获取请求参数
		BigInteger i = extractFromRequest(req);
		//拓展请求参数处理
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		//设置响应数据
		encodeIntoResponse(response, factors);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
