package interface_test.jdk8_new_characteristic;

/**
 * @author moubin.mo
 * @date: 2020/5/30 18:51
 */

public class JDK8InterfaceImpl implements JDK8Interface {
	public static void main(String[] args) {
		// static方法必须通过接口类调用
		JDK8Interface.test();

		//default方法必须通过实现类的对象调用
		new JDK8InterfaceImpl().defaultMethod();
	}
}
