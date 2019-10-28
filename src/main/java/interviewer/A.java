package interviewer;

/**
 * @author moubin.mo
 * @date: 2019/10/28 15:20
 */

public class A {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.getNumber(0));
	}

	public int getNumber(int a){
		return a+1;
	}


}

class B extends A{
	public int getNumber(int a, char c){
		return a + 2;
	}

}