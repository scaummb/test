package design_module.ProxyPattern.dynamicProxy2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * CGlib 动态代理类,实现  MethodInterceptor 接口
 * </p>
 */
public class CGlibMyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("开始CGLib动态代理");
		Object object = proxy.invokeSuper(obj, args);
		System.out.println("结束CGLib动态代理");
		return object;
	}
}