package shizhanthread.chapter2;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * @author moubin.mo
 * @date: 2020/11/29 22:48
 */

public class BaseClass {

	public void encodeIntoResponse(ServletResponse response, BigInteger[] factors) {
	}

	public BigInteger[] factor(BigInteger count) {
		return new BigInteger[]{count};
	}

	public BigInteger extractFromRequest(ServletRequest req) {
		return BigInteger.valueOf(1);
	}

}
