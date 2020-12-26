package design_module.AbstractFactoryPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 22:33
 */

public interface Shape {
	void draw();
}
class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

