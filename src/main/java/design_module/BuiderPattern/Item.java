package design_module.BuiderPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/27 17:17
 */
//快餐店的点餐条目规范接口
public interface Item {
	//动作1：获取名字
	public String name();
	//动作2：打包
	public Packing packing();
	//动作3：价格展示
	public float price();
}
