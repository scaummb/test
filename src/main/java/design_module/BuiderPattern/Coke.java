package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:33
 */
//可口可乐
public class Coke extends ColdDrink {
	@Override
	public float price() {
		//可乐价格
		return 30.0f;
	}

	@Override
	public String name() {
		//可乐名称
		return "Coke";
	}
}
