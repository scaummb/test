package stream;

/**
 * @author moubin.mo
 * @date: 2019/9/15 11:58
 */

public class Female {
	private Integer age;
	private String name;
	private Integer height;
	private Integer weight;
	private Integer nation; // 1:china,2:others
	private Byte gender; // 1:male,2:female

	public Female(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	public Female(Integer age, String name, Integer height, Integer weight, Integer nation, Byte gender) {
		this.age = age;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.nation = nation;
		this.gender = gender;
	}

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Female{" +
				"age=" + age +
				", name='" + name + '\'' +
				", height=" + height +
				", weight=" + weight +
				", nation=" + nation +
				", gender=" + gender +
				'}';
	}

	public void out(Female female) {
		System.out.println("Female{" +
				"age=" + age +
				", name='" + name + '\'' +
				", height=" + height +
				", weight=" + weight +
				", nation=" + nation +
				", gender=" + gender +
				'}');
	}
}
