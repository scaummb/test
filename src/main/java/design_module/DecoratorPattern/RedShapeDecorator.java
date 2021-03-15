package design_module.DecoratorPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:27
 */
//抽象装饰器的具体实现：
public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	/**
	 * <p>
	 * 覆盖增强的draw方法：
	 * 实际上就是先调用“我们的类”的方法
	 * 接着在执行装饰器定义的增强功能，譬如：AOP打印日志或其他业务等
	 * </p>
	 */
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}
