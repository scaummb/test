package design_module.BridgePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 20:59
 */

public class RedDrawAPI implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: red, radius: "
				+ radius + ", x: " + x + ", " + y + "]");
	}
}
