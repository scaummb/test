package design_module.FacadePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 22:20
 */
//门面模式
public class TestFacadePattern {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
