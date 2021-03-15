package effectivejava.no3;

/**
 * @author moubin.mo
 * @date: 2020/10/24 21:22
 */

public class Elvis {
	// 公有成员
	public static final Elvis INSTANCE = new Elvis();

	//构造器保持为私有，导出公有静态成员，客户端可以访问该类的唯一实例
	private Elvis() {
		//...
	}

	public void leaveTheBuilding() {
		//...
	}
}
