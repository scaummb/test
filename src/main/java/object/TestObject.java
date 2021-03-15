package object;

import java.util.Arrays;
import java.util.Objects;

/**
 * REMARK
 * 1) ==以及Object类的equals方法默认都是根据对象的哈希值判断两个对象是否相等。
 * equals:可通过覆盖Object的equals方法来重写比较规则。
 * ==：比较两个对象的首地址
 * <p>
 * 2)  Object类的toString方法默认返回的内容是“对象所属的类名+@+对象的哈希值(十六进制)。
 *
 * @author: mmb
 * @date: 19-11-4
 */
public class TestObject {
	public static void main(String[] args) throws CloneNotSupportedException {
		testArrayObjectClone();
		testCloneObjectException();
		testCloneArrayObject();
		TestObject testObject = new TestObject();
		testObject.clone();
		try {
			testObject.finalize();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		testObject.getClass();
		testObject.hashCode();
		testObject.notify();
		testObject.notifyAll();
		try {
			testObject.finalize();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		try {
			testObject.wait();
			testObject.wait(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		testObject.toString();
	}

	private static void testCloneArrayObject() {
		A[] aArray = new A[]{new A(), new A()};
		A[] aArrayClone = aArray.clone();
		System.out.println("testCloneArrayObject : " + aArray + " value = " + Arrays.toString(aArray));
		System.out.println("testCloneArrayObject : " + aArrayClone + " value = " + Arrays.toString(aArrayClone));
	}

	private static void testCloneObjectException() {
		A aa = new A();
		A a = new A();
		a.setA(aa);
		try {
			Object aClone = a.clone();
			System.out.println(a + " value = " + a.getA());
			System.out.println(aClone + " value = " + a.getA());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public class B {
	}

	/**
	 * 为什么要实现Cloneable接口，明明这个接口并未定义任何方法？
	 * 1、首先看雪Cloneable接口源码注释
	 * Invoking Object's clone method on an instance that does not implement the
	 * * <code>Cloneable</code> interface results in the exception
	 * * <code>CloneNotSupportedException</code> being thrown.
	 * 如果一个对象没有实现 Cloneable 接口而调用了 clone 方法，那么将会抛出 CloneNotSupportedException 异常
	 * <p>
	 * By convention, classes that implement this interface should override
	 * * <tt>Object.clone</tt> (which is protected) with a public method.
	 * * See {@link java.lang.Object#clone()} for details on overriding this
	 * * method.
	 * 按照惯例，实现了  Cloneable 接口应该要覆盖实现 clone 方法，并且声明访问权限为 public
	 * <p>
	 * 2、说到重点了，为啥建议我们开发者覆盖实现一个public的clone方法呢？
	 * 因为，Object 的 clone 方法 protected；所以只能在子类内部调用 Object 基类提供的 clone 方法。
	 * 而无法通过创建对象来调用，eg，Instance instance = new Instance(); instance.clone;//error!!cannot compiled!!
	 * 3、Cloneable 接口仅仅只是标识接口。
	 */
	static class A implements Cloneable {
		private A a;

		public A getA() {
			return a;
		}

		public void setA(A a) {
			this.a = a;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

	private static void testArrayObjectClone() {
		int[] ints = new int[]{1, 2, 3, 4, 5};
		int[] clone = ints.clone();
		System.out.println(ints + " value = " + Arrays.toString(ints));
		System.out.println(clone + " value = " + Arrays.toString(clone));
	}

	private static void test11() {
		Person p1 = new Person(20);
		Person p2 = new Person(20);
		Person p3 = p1;

		Demo d = new Demo();

		System.out.println(p1 == p2);//false
		System.out.println(p1.equals(p2));//false
		System.out.println(p1.equals(p3));//true
		System.out.println(p1.equals(d));//false


		Objects.equals(p1, p3);

		new Long(1);

	}

}

class Person {
	private int age;

	Person(int age) {
		this.age = age;
	}

	//比较Person的年龄,是否是同龄人
	//一般都会覆盖此方法,根据对象的特有内容,建立判断对象是否相同的依据。
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			throw new ClassCastException("类型错误");
		Person p = (Person) obj;
		return this.age == p.age;
	}

}

class Demo {
}