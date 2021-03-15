package design_module.ProxyPattern.dynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * JDK 动态代理类
 * </p>
 */
public class JDKDynamicProxy implements InvocationHandler {
	//被代理类的实例
	private IUserDao iud;

	//构造方法
	public JDKDynamicProxy(IUserDao iud) {
		this.iud = iud;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("开始JDK动态代理");
		method.invoke(iud, args);
		System.out.println("结束JDK动态代理");
		return result;
	}
}