package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:04
 */

public class Square extends Shape {
	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
