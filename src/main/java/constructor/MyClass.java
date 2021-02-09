package constructor;

/**
 * <p>
 *     细节很重要，分清方法还是构造器
 * </p>
 */

public class MyClass {
	long var;
	Long var2;
	public void MyClass(long param){
		var = param;
	}
	public void MyClass(Long param){
		var = param;
	}

	public static void main(String[] args) {
		MyClass a,b;
		a = new MyClass();
		//基础类型，不会自动装箱，因此会报错
		//		b = new MyClass(19);
	}
}
