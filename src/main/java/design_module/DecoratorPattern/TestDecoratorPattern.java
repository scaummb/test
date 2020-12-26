package design_module.DecoratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:29
 */

public class TestDecoratorPattern {
	public static void main(String[] args) {
		Shape circle = new Circle();

		//我们看到，装饰器类 ShapeDecorator 和 普通类 Shape 是同本同根的！
//		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
//		ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
