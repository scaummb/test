package reflect.childrenParentClassFieldReflect;

/**
 * @author moubin.mo
 * @date: 2020/8/9 18:14
 */

public class Daughter extends Parent{
	private String name;
	private Integer age;

	public Daughter(Integer age, String name) {
		super(11);
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public Integer getAge() {
//		return age;
//	}
//
//	@Override
//	public void setAge(Integer age) {
//		this.age = age;
//	}
}
