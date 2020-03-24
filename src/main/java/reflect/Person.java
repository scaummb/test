package reflect;/**
 * <p$description</p>
 */

/**
 * @author moubin.mo
 * @date: 2020/3/18 20:52
 */

public class Person {
	private String name;
	private int age = 0;
	Person(){
		name = "default name";
	}
	Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	Person(String name){
		this.name = name;
	}
	String selfIntroduction(){
		return "Hello!My name is '"+name+"'";
	}
	void say(String something){
		System.out.println(name+"说："+something);
	}
	boolean wasDead(){
		return age > 200;
	}
	public String getName(){
		return name;
	}
}
