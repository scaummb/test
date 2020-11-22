package object;

/**
 * @author moubin.mo
 * @date: 2020/11/22 18:31
 */

public class TestEqual {
	public static void main(String[] args) {
		Address address1 = new Address();
		Person person = new Person(11);
		System.out.println("address1.equals(person):" + address1.equals(person));
	}
}
