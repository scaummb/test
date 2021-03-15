package design_module.SinglePattern;

/**
 * 懒汉式，对比SingletonCase1，给方法加了排它锁，这是线程安全的写法。
 * 用到这个实例时才去调用方法实例化。但是，我们把整个方法都同步了，效率很低下，我们可以继续优化，只在创建实例的地方加上同步
 */
public class SingletonCase2 {
	private static SingletonCase2 singleton = null;

	public SingletonCase2() {
	}

	/**
	 * 整个方法锁住了，效率较低
	 *
	 * @return
	 */
	public synchronized static SingletonCase2 getInstance() {
		if (singleton == null) {
			singleton = new SingletonCase2();
		}
		return singleton;
	}
}
