package method;

/**
 * @author moubin.mo
 * @date: 2020/5/14 14:57
 */

public class TestMethodParameters {
	public static void main(String[] args) {
		TestMethodParameters testMethodParameters = new TestMethodParameters();
		A a = new A();
		a.setNum(10L);
		System.out.println(a);
		a = testMethodParameters.test1(a);
		System.out.println(a);


	}

	private A test1(A a) {
		A a1 = new A();
		a1.setNum(110L);
		a = a1;
		System.out.println(a);
		return a1;

	}


}


class A {
	private Long num;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}