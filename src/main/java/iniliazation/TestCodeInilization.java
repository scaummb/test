package iniliazation;

/**
 * <p>
 *     1、静态代码块：父类 then 子类
 *     1.5、父类成员变量
 *     2、父类普通代码块&构造器： 普通代码块优先于构造器
 *     2.5、子类成员变量
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
	private BaseMember member = new BaseMember();
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
	private SubClassMember subClassMember = new SubClassMember();
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

class BaseMember{
	public BaseMember() {
		System.out.println("Basic Member");
	}
}

class SubClassMember{
	public SubClassMember() {
		System.out.println("SubClass Member");
	}
}