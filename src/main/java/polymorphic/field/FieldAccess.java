package polymorphic.field;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class FieldAccess {
	public static void main(String[] args) {

		Super sup = new Sub();
		// 域是编译器实现的工作，任何域的访问操作都是由编译器解析，因此不是多态的。、
		// 这样，Sub实际上包含两个成为field的域，它自己的和从Super处得到的。
		System.out.println(sup.field + " - " + sup.getField());
		Sub sub = new Sub();
		System.out.println(sub.field + " - " + sub.getField() + " - " + sub.getSuperField());

	}
}

class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;

	public int getField() {
		return field;
	}

	public int getSuperField() {
		return super.getField();
	}
}