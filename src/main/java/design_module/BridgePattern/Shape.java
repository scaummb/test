package design_module.BridgePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 21:00
 */
//Shape：定义形状
public abstract class Shape {
	protected DrawAPI drawAPI;
	// 传入功能对象
	protected Shape(DrawAPI drawAPI){
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}
