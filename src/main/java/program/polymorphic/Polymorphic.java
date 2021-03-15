package program.polymorphic;/**
 * <p$description</p>
 */

/**
 * 方法覆盖，父类指向子类
 *
 * @author moubin.mo
 * @date: 2020/3/24 09:00
 */

public class Polymorphic {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.cry();
		Animal animal = new Cat();
		animal.cry();
		animal = new Dog();
		animal.cry();
	}
}
