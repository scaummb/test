package effectivejava.no3;

import java.io.Serializable;

/**
 * @author moubin.mo
 * @date: 2020/10/24 21:35
 */

public class Elvis2 implements Serializable {
	// 私有成员
	private static final Elvis2 INSTANCE = new Elvis2();

	// 静态方法公有成员
	public static Elvis2 getInstance(){
		return INSTANCE;
	}

	//构造器保持为私有，导出公有静态成员，客户端可以访问该类的唯一实例
	private Elvis2(){
		//...
	}

	// readResolve method to preserve singleton property
	private Object readObject(){
		// Return the one true Elvis and let the garbage collector take care of the Elvis impersonator
		return INSTANCE;
	}

	public void leaveTheBuilding(){
		//...
	}
}
