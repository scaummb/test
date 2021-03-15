package shizhanthread.chapter2;

import shizhanthread.annotations.NotThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author moubin.mo
 * @date: 2020/11/29 22:34
 */
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

	private long count = 10;

	public long getCount() {
		return count;
	}

	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

	@Override
	public synchronized void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {

		//获取请求参数
		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber.get())) {
			encodeIntoResponse(response, lastFactors.get());
		} else {
			//拓展请求参数处理
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			//设置响应数据
			encodeIntoResponse(response, factors);
		}
	}

	private void encodeIntoResponse(ServletResponse response, BigInteger[] bigInteger) {
	}

	private BigInteger[] factor(BigInteger count) {
		return new BigInteger[]{count};
	}

	private BigInteger extractFromRequest(ServletRequest req) {
		return BigInteger.valueOf(1);
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
