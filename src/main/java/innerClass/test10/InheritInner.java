package innerClass.test10;

class WithInner {
	class Inner {
	}
}

// 内部类继承，但是需要指明继承关系
public class InheritInner extends WithInner.Inner {
	public InheritInner(WithInner wi) {
		//默认调用外围类的引用的构造器
		wi.super();
	}

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}
