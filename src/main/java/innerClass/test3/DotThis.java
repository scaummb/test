package innerClass.test3;

/**
 * <p>
 * 若要生成对外部对象的引用，使用类名+“.this”的方式。
 * </p>
 */
public class DotThis {
	//外围类方法1
	void f() {
		System.out.println("DotThis.f()");
	}

	//外围类方法2:创建内部类
	public Inner inner() {
		return new Inner();
	}

	//内部类
	public class Inner {
		// 返回外部类的引用
		public DotThis outerClass() {
			//类名.this返回外围类引用
			return DotThis.this;
		}
	}

	public static void main(String[] args) {
		DotThis dotThis = new DotThis();
		//创建了一个内部类
		DotThis.Inner dti = dotThis.inner();
	}
}