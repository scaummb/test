package innerClass.test8;

/**
 * <p>
 * 匿名内部类
 * </p>
 */
public class Parcel7 {
	//匿名内部类方法-形式1:抽象接口+接口方法实现
	public Contents contents() {
		return new Contents() {
			private int i = 11;

			@Override
			public int value() {
				return i;
			}
		};
	}

	//匿名内部类方法-形式2:显式声明接口的实现类并返回该类的实例
	class MyContents implements Contents {
		private int i = 11;

		@Override
		public int value() {
			return i;
		}
	}

	public Contents contentsV2() {
		return new MyContents();
	}

	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
		Contents c2 = p.contentsV2();
	}
}