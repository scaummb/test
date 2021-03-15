package design_module.SinglePattern;

/**
 * 普通写法
 */
public class SingletonCase1 {
	private static SingletonCase1 singleton = null;

	public SingletonCase1() {
	}

	/**
	 * 并发下会产生多个实例
	 */
	public static SingletonCase1 getInstance() {
		if (singleton == null) {
			singleton = new SingletonCase1();
		}
		return singleton;
	}
}
