package effectivejava.no20;

/**
 * @author moubin.mo
 * @date: 2020/11/22 08:42
 */

// 标签类 - vastly inferior to a class hierarchy
public class Figure {
	// 形状枚举
	enum Shape {
		RECTANGLE, //三角形
		CIRCLE //圆形
	}

	// 标签域 field - the shape of this figure
	final Shape shape;

	// RECTANGLE:宽高
	double length;
	double width;

	// CIRCLE：半径
	double radius;

	// 构造器：三角形
	public Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	// 构造器：圆形
	public Figure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	// 计算面积
	double area() {
		switch (shape) {
			case RECTANGLE:
				return length * width;
			case CIRCLE:
				return Math.PI * (radius * radius);
			default:
				throw new AssertionError();
		}
	}
}
