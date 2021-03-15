package innerClass.test7;

/**
 * <p>
 * 任意代码块中嵌入内部类(内部类与别的类一起被编译。在作用域之外不可访问。此外与普通类一样。)
 * </p>
 */
public class TestMethodCodeBlockInnerClass {
	private void internalTracking(boolean b) {
		if (b) {
			//任意代码块中嵌入内部类，那么只能在该代码块中生效，在代码块外不能被访问。
			class TrackingSlip {
				private String id;

				public TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		// Can’t use it here! Out of scope:
		//这里编译会报错，无法引用到 TrackingSlip
//         TrackingSlip ts = new TrackingSlip("x");
	}

	//外围类提供方法1
	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		// 创建外围类
		TestMethodCodeBlockInnerClass p = new TestMethodCodeBlockInnerClass();
		p.track();
	}
}
