package final_test;

/**
 * @author moubin.mo
 * @date: 2020/11/12 22:58
 */

public class TestFinalParam {
	public static void main(String[] args) {

	}

	private static void test(final int a){
//		a = 11;
	}
	private static void test2(final Integer a){
//		a = 11;
	}
	private static void test3(final A a){
		a.setA(10);
//		a = new A();
	}

}
class A {
	private Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}
}