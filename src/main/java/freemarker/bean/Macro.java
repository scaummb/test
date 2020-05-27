package freemarker.bean;

import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/5/27 14:19
 */

public class Macro {
	private String name;
	private Integer age;
	private List<Macro> dtos;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Macro> getDtos() {
		return dtos;
	}

	public void setDtos(List<Macro> dtos) {
		this.dtos = dtos;
	}
}
