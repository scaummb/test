package design_module.BuilderPattern.testcase1;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:29
 */
//汉堡包
public abstract class Burger implements Item {
	//汉堡默认使用了纸质打包方式
	@Override
	public Packing packing() {
		return new PaperWrapper();
	}

	@Override
	public abstract float price();
}
