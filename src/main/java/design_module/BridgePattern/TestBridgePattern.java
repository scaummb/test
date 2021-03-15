package design_module.BridgePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:07
 */

public class TestBridgePattern {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100, 100, 10, new RedDrawAPI());
		Shape greenCircle = new Circle(100, 100, 10, new GreenDrawAPI());
		//Shape将Draw和Circle，两个不同意义的对象桥接到一起，后续如果说有个rectangle（矩形）的Shape要实现作图功能，那么我们只需定义一个新的Shape子类，以及新的DrawAPI动作即可，无需额外将两者耦合到一块！
		redCircle.draw();
		greenCircle.draw();
	}
}
