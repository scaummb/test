package innerClass.test11;

/**
 * <p>
 * 两个内部类是完全独立的实体。各自在自己的命名空间内。
 * </p>
 */
class Egg {
	private Yolk y;

	//父类的内部类
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}

	//父类构造器
	public Egg() {
		System.out.println("new Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg {
	//覆盖了父类Egg的内部类Yolk
	public class Yolk {
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {
		new BigEgg();
	}
}