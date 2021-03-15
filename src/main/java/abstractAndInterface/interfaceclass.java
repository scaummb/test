package abstractAndInterface;

/**
 * @author moubin.mo
 * @date: 2021/1/12 14:24
 */
//一个接口可以继承多个接口
public interface interfaceclass extends interface2, interface1 {
	//不含有私有成员变量
	abstract void test();

	void test1();

	abstract String test2();

	public default void test3() {
	}
}
