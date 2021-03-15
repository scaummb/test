package program.polymorphic;/**
 * <p$description</p>
 */

/**
 * @author moubin.mo
 * @date: 2020/3/24 09:00
 */

public class Animal {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void cry() {
		System.out.println("how to cry..");
	}
}

class Cat extends Animal {
	@Override
	public void cry() {
		System.out.println("miao miao");
	}
}

class Dog extends Animal {
	@Override
	public void cry() {
		System.out.println("wang wang");
	}
}