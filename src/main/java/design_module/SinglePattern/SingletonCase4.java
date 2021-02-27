package design_module.SinglePattern;

/**
 * 懒汉模式之一
 * 双重检验
 * 双重非空判断，new对象前加一次锁。
 * volatile关键字，考虑的是，new关键字在虚拟机中执行时其实分为很多步骤，具体原因可以参考深入理解java虚拟机一书（考虑的是这个new关键字字节码执行时是非原子性的），而volatile关键字可以防止指令重排。
 */

public class SingletonCase4 {

	/**volatile防止指令重排*/
	private static volatile SingletonCase4 singleton;

	public SingletonCase4() {
	}

	/**
	 * 只是在实例为空时才进行同步创建
	 * 为什么做了2次判断？
	 * A线程和B线程同时进入同步方法 getInstance
	 * 然后都在1位置处判断了实例为null
	 * 然后都进入了同步块2中
	 * 然后A线程优先进入了同步代码块2中（B线程也进入了），然后创建了实例
	 * 此时，如果没有3处的判断，那么A线程创建实例同时，B线程也会创建一个实例
	 * 所以，还需要做2次判断
	 * */
	public static SingletonCase4 getInstance(){
		if (singleton == null){
			synchronized (SingletonCase4.class){
				if (singleton == null){
					singleton = new SingletonCase4();
				}
			}
		}
		return singleton;
	}

}
