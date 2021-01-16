package design_module.BuilderPattern.testcase1;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:31
 */
//冷饮
public abstract class ColdDrink implements Item {

	//饮料默认使用了瓶装打包方式
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
