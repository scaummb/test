package design_module.ProxyPattern.dynamicProxy2;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * <p>
 * 可以看出使用Enhancer生成代理类，需要设置被代理类，也就是父类（从这里可以看出是使用继承，生成的子类），
 * 设置回调方法
 * </p>
 */
public class Test3 {
	public static void main(String[] args) {
		//可以指定 CGLIB 将动态生成的代理类保存至指定的磁盘路径下
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\code\\test\\src\\main\\java\\design_module\\ProxyPattern\\dynamicProxy2");

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(SubjectA.class);
		enhancer.setCallback(new CGlibMyMethodInterceptor());
		//生成代理类
		SubjectA ud = (SubjectA) enhancer.create();
		ud.find();
		enhancer.setSuperclass(SubjectB.class);
		SubjectB ud2 = (SubjectB) enhancer.create();
		ud2.find();
	}
}

class SubjectA {
	void find() {
		System.out.println("SubjectA");
	}
}

class SubjectB {
	void find() {
		System.out.println("SubjectB");
	}
}