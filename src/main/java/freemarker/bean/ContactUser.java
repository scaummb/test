package freemarker.bean;

/**
 * @author moubin.mo
 * @date: 2020/5/27 01:39
 */

public class ContactUser {
	private String name;
	private Integer age;
	private String token;

	public ContactUser() {
	}

	public ContactUser(String name, Integer age, String token) {
		this.name = name;
		this.age = age;
		this.token = token;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
