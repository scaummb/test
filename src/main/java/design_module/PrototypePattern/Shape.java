package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:02
 */

public abstract class Shape implements Cloneable {
	protected String type;

	// 定义动作
	abstract void draw();

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	//克隆方法
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
