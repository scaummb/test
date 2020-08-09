package reflect.childrenParentClassFieldReflect;

/**
 * @author moubin.mo
 * @date: 2020/8/8 21:28
 */

public class Son extends Parent {
	private String name;

	public Son(Integer age, String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
