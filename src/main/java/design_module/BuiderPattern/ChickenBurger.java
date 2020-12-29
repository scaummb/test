package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:37
 */
//鸡翅汉堡
public class ChickenBurger extends Burger {
	@Override
	public float price() {
		//价格
		return 50.5f;
	}

	@Override
	public String name() {
		//名称
		return "Chicken Burger";
	}
}
