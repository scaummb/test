package design_module.BridgePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:00
 */

public class GreenDrawAPI implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: "
				+ radius +", x: " +x+", "+ y +"]");
	}
}
