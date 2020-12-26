package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:02
 */

public abstract class Shape implements Cloneable {
	private String id;
	protected String type;

	// 定义动作
	abstract void draw();

	public String getType(){
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
