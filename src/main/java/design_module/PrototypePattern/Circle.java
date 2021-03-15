package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:04
 */
public class Circle extends Shape {
	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}