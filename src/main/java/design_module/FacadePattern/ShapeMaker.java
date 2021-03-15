package design_module.FacadePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 22:19
 */

public class ShapeMaker {
	// 封装了多个对象，匹配不同的对象和行为
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		//构造器对多个内置对象完成初始化
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}
