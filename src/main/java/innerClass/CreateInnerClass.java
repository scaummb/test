package innerClass;

/**
 * @author moubin.mo
 * @date: 2021/2/1 02:29
 */

//外围类
public class CreateInnerClass {
	//内部类1
	class Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}

	//内部类2
	class Destination {
		private String label;
		public Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}

	//外围类方法
	public void setDest(String dest) {
		// 外围类的方法内部，完成内部类的构造
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}

	//外围类方法2
	public Destination getAnotherDestination(){
		return new Destination("anotherDestination");
	}
	//外围类方法3
	public Contents getAnotherContents(){
		return new Contents();
	}

	public static void main(String[] args) {
		//新建外围类
		CreateInnerClass innerClass = new CreateInnerClass();
		innerClass.setDest("Tasmania");
		//外部类可以拥有返回指向内部类引用的方法。
		Destination anotherDestination = innerClass.getAnotherDestination();
		Contents anotherContents = innerClass.getAnotherContents();
	}
}
