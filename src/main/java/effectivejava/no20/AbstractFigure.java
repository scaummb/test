package effectivejava.no20;

/**
 * @author moubin.mo
 * @date: 2020/11/22 08:52
 */

public abstract class AbstractFigure {
	abstract double area();
}

//圆形
class Circle extends AbstractFigure {
	final double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return Math.PI * (radius * radius);
	}
}
//矩形
class Rectangle extends AbstractFigure {
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	double area() {
		return length * width;
	}
}