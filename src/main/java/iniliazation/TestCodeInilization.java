package iniliazation;

/**
 * <p>
 *     1、静态代码块：父类 then 子类
 *     2、父类普通代码块&构造器： 普通代码块优先于构造器
 *     3、子类普通代码块&构造器： 普通代码块优先于构造器
 *     1-》2—》3
 * </p>
 * @author moubin.mo
 * @date: 2021/1/13 11:17
 */

public class TestCodeInilization {
	public static void main(String[] args) {
		new SubClass();
	}
}
class Basic {
	static {
		System.out.println("Basic static block");
	}
	{
		System.out.println("Basic block");
	}

	public Basic() {
		System.out.println("Basic Constructor");
	}
}

class SubClass extends Basic{
	static {
		System.out.println("SubClass static block");
	}

	{
		System.out.println("SubClass block");
	}

	public SubClass() {
		System.out.println("SubClass Constructor");
	}
}