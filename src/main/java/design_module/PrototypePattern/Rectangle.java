package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:03
 */

public class Rectangle extends Shape {
	public Rectangle(){
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
