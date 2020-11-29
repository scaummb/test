package shizhanthread.chapter2;

import shizhanthread.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author moubin.mo
 * @date: 2020/11/29 22:06
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet {
	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
//		//获取请求参数
//		BigInteger count = extractFromRequest(req);
//		//拓展请求参数处理
//		BigInteger[] factors = factor(count);
//		//设置响应数据
//		encodeIntoResponse(response, factors);
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
