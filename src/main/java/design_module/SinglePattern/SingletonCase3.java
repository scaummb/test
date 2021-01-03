package design_module.SinglePattern;

/**
 * 饿汉式
 * 饿汉式的特点是：类在加载时就直接初始化了实例。即使没用到，也会实例化，因此，也是线程安全的单例模式。
 */

public class SingletonCase3 {
	/**类在加载的时候直接进行初始化*/
	private static SingletonCase3 singleton = new SingletonCase3();

	public SingletonCase3() {
	}
	/**
	 * 对外暴露唯一接口
	 * 提供单例对象
	 */
	public static SingletonCase3 getInstance(){
		return singleton;
	}
}
