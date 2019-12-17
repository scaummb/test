package design.SinglePattern;

/**
 * 普通写法
 * @author moubin.mo
 * @date: 2019/12/17 16:11
 */

public class SingletonCase1 {
	private static SingletonCase1 singleton = null;

	public SingletonCase1() {
	}

	/**
	 * 并发下会产生多个实例
	 */
	public static SingletonCase1 getInstance(){
		if (singleton == null){
			singleton = new SingletonCase1();
		}
		return singleton;
	}

}
