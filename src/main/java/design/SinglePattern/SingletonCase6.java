package design.SinglePattern;

/**
 * 枚举类
 * 本质就是：创建一个枚举类，封装一个对象,枚举类私有构造器中初始化对象
 * @author moubin.mo
 * @date: 2019/12/17 16:11
 */

public class SingletonCase6 {
	static enum SingletonEnum {
		//创建一个枚举对象，该对象天生为单例
		INSTANCE;
		private SingletonCase6 singleton;

		//私有化枚举的构造函数
		private SingletonEnum() {
			System.out.print("-----1-----");
			singleton = new SingletonCase6();
		}

		public SingletonCase6 getSingleton() {
			System.out.print("-----2-----");
			return singleton;
		}
	}

	private SingletonCase6() {
	}

	public static SingletonCase6 getInstance(){
		System.out.print("-----3-----");
		return SingletonEnum.INSTANCE.getSingleton();
	}

	public static void main(String[] args) {
		getInstance();
	}
}
