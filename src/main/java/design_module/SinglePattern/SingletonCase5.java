package design_module.SinglePattern;

/**
 * 内部类
 * 优点：由于静态内部类跟外部类是平级的，所以外部类加载的时候不会影响内部类，因此实现了lazy loading, 同时也是利用静态变量的方式，使得INSTANCE只会在SingletonHolder加载的时候初始化一次，从而保证不会有多线程初始化的情况，因此也是线程安全的。
 * @author moubin.mo
 * @date: 2019/12/17 16:11
 */

public class SingletonCase5 {
	//静态内部类,懒加载：在被用到时才加载（根据内部类不会在其外部类被加载的同时被加载的事实）
	private static class SingletonCase5Holder{
		private static final SingletonCase5 singleton = new SingletonCase5();
	}

	public SingletonCase5() {
	}

	public static SingletonCase5 getInstance(){
		return SingletonCase5Holder.singleton;
	}

}
