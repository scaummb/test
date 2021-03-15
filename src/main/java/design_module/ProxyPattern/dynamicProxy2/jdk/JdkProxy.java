package design_module.ProxyPattern.dynamicProxy2.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
	private Trancation2 trancation;
	private Ihello target;

	public JdkProxy(Trancation2 trancation, Ihello target) {
		this.trancation = trancation;
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 开启事务
		trancation.beginTrancation();
		// 方法调用，注！！！此处传入的Object为代理，而不是目标类，目标类需要另外注入
		Object obj = method.invoke(target, args);
		// 开启事务
		trancation.commit();
		return obj;
	}
}

// jdk的代理需要实现接口
interface Ihello {
	void sayHello();
}

// 人员DAO
class IHeloImpl implements Ihello {
	@Override
	public void sayHello() {
		System.out.println("保存人员");
	}
}

// 事务
class Trancation2 {
	public void beginTrancation() {
		System.out.println("开启事务");
	}

	public void commit() {
		System.out.println("提交事务");
	}
}

// 客户端
class Client2 {
	public static void main(String[] args) {
		Trancation2 t2 = new Trancation2();
		Ihello helo = new IHeloImpl();
		JdkProxy jdkProxy = new JdkProxy(t2, helo);
		Ihello helloProxy = (Ihello) Proxy.newProxyInstance(helo.getClass().getClassLoader(), helo.getClass().getInterfaces(), jdkProxy);
		helloProxy.sayHello();
	}
}