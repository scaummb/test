package effectivejava.no4;

/**
 * @author moubin.mo
 * @date: 2020/12/10 23:33
 */
//不可实例化的工具类
public class UtinityClass {
	//显式声明一个私有化的构造器，使得无法实例化该类
	private UtinityClass() {
		throw new AssertionError();
	}

}
