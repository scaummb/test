package transient_test;

import Utils.StringHelper;

import java.io.*;

/**
 * <p>
 * java的serialization提供了一个非常棒的存储对象状态的机制，说白了serialization就是把对象的状态存储到硬盘上 去，等需要的时候就可以再把它读出来使用。有些时候像银行卡号这些字段是不希望在网络上传输的，transient的作用就是把这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化，意思是transient修饰的age字段，他的生命周期仅仅在内存中，不会被写到磁盘中。
 * <p>
 * 1、transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。
 * 2、被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化
 * 3、一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。也可以认为在将持久化的对象反序列化后，被transient修饰的变量将按照普通类成员变量一样被初始化。
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/29 12:23
 */

public class TestTransient implements Serializable {

	static int[] a = {};

	String age = "age";
	transient String param = "param";

	public TestTransient() {
	}

	public TestTransient(final String age, final String param) {
		this.age = age;
		this.param = param;
	}

	public static int[] getA() {
		return TestTransient.a;
	}

	public static void setA(final int[] a) {
		TestTransient.a = a;
	}

	public String getParam() {
		return this.param;
	}

	public void setParam(final String param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return StringHelper.toJsonString(this);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		a = new int[]{123};

		File file = new File("E:\\code\\test\\src\\main\\java\\transient_test\\a.txt");

		// 写入对象数据
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new TestTransient());
		objectOutputStream.close();

		// 读取对象数据
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		TestTransient o = (TestTransient) objectInputStream.readObject();
		System.out.println(o.toString()); //{"age":"age"}
	}
	//我们知道在Java中，对象的序列化可以通过实现两种接口来实现，若操作的是一个 Serializable 对象，则所有的序列化将会自动进行，若操作的是 一个 Externalizable 对象，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。

}
