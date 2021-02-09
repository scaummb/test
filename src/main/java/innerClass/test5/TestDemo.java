package innerClass.test5;

/**
 * @author moubin.mo
 * @date: 2021/2/1 11:53
 */

public class TestDemo extends TestInterfaceInnerClass{
	public static void main(String[] args) {
		TestInterfaceInnerClass p = new TestInterfaceInnerClass();
		Conents contents = p.contents();
		Destination tasmania = p.destination("Tasmania");
	}
}
