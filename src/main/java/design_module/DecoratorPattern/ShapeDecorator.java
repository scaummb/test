package design_module.DecoratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:25
 */
//抽象装饰器！！实际上就是对Shape进行了一次上层封装。。
public abstract class ShapeDecorator implements Shape {
	//我们的类啊！
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	//实际调用我们的类方法！
	public void draw() {
		decoratedShape.draw();
	}
}
