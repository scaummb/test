package iniliazation;

/**
 * <p>
 * this关键字
 * testcase：return this，返回对象引用
 * </p>
 *
 * @author momoubin
 * @date 2020/5/3
 */
public class TestThis {
	public static void main(String[] args) {
		new Person().eat(new Apple());
	}
}

class Person {
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler {
	// 工具方法，应用于很多地方，不想重复这些代码
	static Apple peel(Apple apple) {
		return apple;
	}
}

class Apple {
	Apple getPeeled() {
		// 返回引用,将自身传递给外部方法
		return Peeler.peel(this);
	}
}