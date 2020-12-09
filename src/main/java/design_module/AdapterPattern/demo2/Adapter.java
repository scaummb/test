package design_module.AdapterPattern.demo2;

/**
 * @author moubin.mo
 * @date: 2020/5/30 18:16
 */

public class Adapter implements Target {
	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void method1() {

	}

	@Override
	public void method2() {
		System.out.println("Adapter - method 2");
	}
}
