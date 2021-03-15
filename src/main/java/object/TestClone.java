package object;

import lombok.Data;

/**
 * @author moubin.mo
 * @date: 2020/11/22 18:05
 */

public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {


		Address address = new Address();
		address.setType("Home");
		address.setValue("北京");
		Personclone p1 = new Personclone();
		p1.setAge(31);
		p1.setName("Peter");
		p1.setAddress(address);
		Personclone p2 = (Personclone) p1.clone();
		System.out.println("p1 == p2:" + (p1 == p2));
		System.out.println("p1=" + p1);
		System.out.println("p2=" + p2);

		System.out.println(address.getClass());
	}
}

@Data
class Personclone implements Cloneable {
	private String name;
	private Integer age;
	private Address address;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

@Data
class Address {
	private String type;
	private String value;
}