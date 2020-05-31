package design.AdapterPattern.demo1;

/**
 * <P>
 *     类适配器模式：
 *     从下面的结构图可以看出，Adaptee类并没有method2()方法，而客户端则期待这个方法。
 *     为使客户端能够使用Adaptee类，我们把Adaptee与Target衔接起来。Adapter与Adaptee是继承关系，这决定了这是一个类适配器模式。
 * </P>
 * @author moubin.mo
 * @date: 2020/5/30 18:16
 */

public class AdapterTest {
	public static void main(String[] args) {
		Adapter adapter = new Adapter();
		adapter.method1();
		adapter.method2();
	}
}

