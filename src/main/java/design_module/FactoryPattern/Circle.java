package design_module.FactoryPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 22:13
 */

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
