package design_module.FactoryPattern;


/**
 * @author moubin.mo
 * @date: 2020/12/26 22:12
 */

public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
