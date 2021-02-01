package abstractAndInterface;

/**
 * <p>
 *     匿名内部类和常规继承类相比有受限，匿名内部类既能继承类，也能实现接口。但不能两者皆备。如果实现接口，只能实现一个接口。
 * </p>
 */

public class TestAnonymousClass {
	//匿名类，接口作返回值
	public static interface1 getInterface1(){
		int a = 1;
		return new interface1(){
			@Override
			public void test() {}
			@Override
			public String test2() {
				return String.valueOf(a);
			}
		};
	}

	public static void main(String[] args) {
		interface1 interface1 = getInterface1();
		System.out.println(interface1);
		String s = interface1.test2();
		System.out.println(s);
	}
}
