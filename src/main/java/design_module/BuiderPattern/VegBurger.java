package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:32
 */
//素食汉堡
public class VegBurger extends Burger {
	@Override
	public float price() {
		//素食汉堡价格
		return 25.0f;
	}

	@Override
	public String name() {
		//素食汉堡名字
		return "Veg Burger";
	}
}
