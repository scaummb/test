package design.AdapterPattern.demo2;

/**
 * <P>
 *     对象适配器模式：
 *     从下面的结构图可以看出，Adaptee类并没有method2()方法，而客户端则期待这个方法。
 *     与类适配器模式一样，为使客户端能够使用Adaptee类，我们把Adaptee与Target衔接起来。但这里我们不继承Adaptee，而是把Adaptee封装进Adapter里。
 *     这里Adaptee与Adapter是组合关系。Target和Adaptee和上面的类适配器一样，不再贴出。
 *
 *     类适配器与对象适配器的区别
 * 		类适配器使用的是继承的方式，直接继承了Adaptee，所以无法对Adaptee的子类进行适配。
 * 		对象适配器使用的是组合的方式，·所以Adaptee及其子孙类都可以被适配。另外，对象适配器对于增加一些新行为非常方便，而且新增加的行为同时适用于所有的源。
 *		基于组合/聚合优于继承的原则，使用对象适配器是更好的选择。但具体问题应该具体分析，某些情况可能使用类适配器会适合，最适合的才是最好的。
 * </P>
 * @author moubin.mo
 * @date: 2020/5/30 18:16
 */

public class AdapterTest {
	public static void main(String[] args) {
		Adapter adapter = new Adapter(new Adaptee());
		adapter.method1();
		adapter.method2();
	}
}

