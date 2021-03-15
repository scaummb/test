package innerclass.complie;

/**
 * @author moubin.mo
 * @date: 2021/2/6 11:47
 */

public class OuterClass {
	class InnerClass {
	}

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		InnerClass innerClass = outerClass.new InnerClass();
	}
}
