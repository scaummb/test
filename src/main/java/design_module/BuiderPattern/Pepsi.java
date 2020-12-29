package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:34
 */
//百事可乐
public class Pepsi extends ColdDrink {
	@Override
	public float price() {
		//价格
		return 35.0f;
	}

	@Override
	public String name() {
		//名称
		return "Pepsi";
	}
}
