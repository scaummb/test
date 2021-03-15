package design_module.ProxyPattern.dynamicProxy2;

import java.lang.reflect.Proxy;

public class Test2 {
	public static void main(String[] args) {
		//被代理类
		UserDao ud = new UserDao();
		WomanDao wd = new WomanDao();
		//代理器（通过构造器设置 被代理类）
		JDKDynamicProxy dp = new JDKDynamicProxy(ud);
		JDKDynamicProxy dp2 = new JDKDynamicProxy(wd);

		//在创建代理对象前，可以通过下面语句，将生成的代理类的.class保存在本地。
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		//生成代理对象1
		IUserDao iud = (IUserDao) Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), dp);
		iud.find();
		//切换代理对象2，生成
		iud = (IUserDao) Proxy.newProxyInstance(wd.getClass().getClassLoader(), wd.getClass().getInterfaces(), dp2);
		iud.find();
	}
}