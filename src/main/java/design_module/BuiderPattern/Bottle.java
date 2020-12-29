package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:28
 */
//瓶装打包
public class Bottle implements Packing {
	@Override
	public String pack() {
		return "Bottle";
	}
}
