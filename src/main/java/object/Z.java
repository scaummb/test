package object;

/**
 * @author moubin.mo
 * @date: 2021/2/1 20:26
 */

public class Z extends X{
	Y y = new Y();

	public Z() {
		System.out.println("Z");
	}

	public static void main(String[] args) {
		new Z();
	}
}
class X{
	Y y = new Y();

	public X() {
		System.out.println("X");
	}
}
class Y{
	public Y() {
		System.out.println("Y");
	}
}
