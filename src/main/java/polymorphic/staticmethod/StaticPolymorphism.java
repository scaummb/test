package polymorphic.staticmethod;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class StaticPolymorphism {
	public static void main(String[] args) {
		// 创建的是子类对象
		StaticSuper staticSub = new StaticSub();
		// 非静态方法，多态，动态绑定对象。StaticSub dynamicGet()
		System.out.println(staticSub.dynamicGet());
		// 静态方法，前期绑定，非多态，编译器完成，跟指定的对象引用有关系。StaticSuper staticGet()
		System.out.println(staticSub.staticGet());
	}
}

class StaticSuper {
	public static String staticGet() {
		return "StaticSuper staticGet() ";
	}

	public String dynamicGet() {
		return "StaticSuper dynamicGet() ";
	}
}

class StaticSub extends StaticSuper {
	public static String staticGet() {
		return "StaticSub staticGet() ";
	}

	public String dynamicGet() {
		return "StaticSub dynamicGet() ";
	}
}