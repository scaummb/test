package interface_test.jdk8_new_characteristic;

/**
 * @author moubin.mo
 * @date: 2020/5/30 18:48
 */

public interface JDK8Interface {

	// static修饰符定义静态方法
	static void test(){
		System.out.println("jdk8 允许接口定义 final static 方法");
	}

	// default修饰符定义默认方法
	default void defaultMethod() {
		System.out.println("jdk8 允许接口定义 default 修饰的方法");
	}

}
