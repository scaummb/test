package design_module.FactoryPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 22:12
 */

public class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
