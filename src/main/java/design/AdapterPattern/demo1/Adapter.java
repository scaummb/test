package design.AdapterPattern.demo1;

/**
 * @author moubin.mo
 * @date: 2020/5/30 18:16
 */

public class Adapter extends Adaptee implements Target {
	@Override
	public void method2() {
		System.out.println("Adapter - method 2");
	}
}
