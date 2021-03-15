package shizhanthread.chapter2;

import shizhanthread.annotations.ThreadSafe;

import javax.servlet.*;
import java.math.BigInteger;

/**
 * @author moubin.mo
 * @date: 2020/11/30 00:23
 */

@ThreadSafe
public class CachedFactoriser extends BaseClass implements Servlet {

	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	private long hits;
	private long cacheHits;

	public synchronized long getHits() {
		return hits;
	}

	public synchronized double getCacheHitRatio() {
		return (double) cacheHits / (double) hits;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if (i.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if (factors == null) {
			factors = factor(i);
			synchronized (this) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}
		encodeIntoResponse(resp, factors);
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
