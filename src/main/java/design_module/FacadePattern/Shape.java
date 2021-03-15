package design_module.FacadePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 22:18
 */

public interface Shape {
	void draw();
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}

