package shizhanthread.chapter2;

import shizhanthread.annotations.ThreadSafe;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * @author moubin.mo
 * @date: 2020/11/30 00:23
 */

@ThreadSafe
public class CachedFactoriser implements Servlet {

	@GuardedBy("this") private BigInteger lastNumber;
	@GuardedBy("this") private BigInteger[] lastFactors;
	@GuardedBy("this") private long hits;
	@GuardedBy("this") private long cacheHits;

	public synchronized long getHits() {return hits;}
	public synchronized double getCacheHitRatio() {
		return (double) cacheHits /(double) hits;
	}

	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if(i.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if(factors == null) {
			factors = factor(i);
			synchronized (this) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}
		encodeIntoResponse(resp,factors);
	}
}
