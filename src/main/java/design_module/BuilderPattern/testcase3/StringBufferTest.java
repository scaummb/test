package design_module.BuilderPattern.testcase3;

/**
 * <p>
 * 这两个类最主要的区别就是StringBuilder线程不安全，StringBuffer线程安全。
 * AbstractStringBuilder 实现了 Appendable 接口方法所有append()方法，俨然AbstractStringBuilder 已经是就建造者，只是是一个抽象类AbstractStringBuilder ，不能实例化。
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/16 16:22
 */

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("chars")
				.append(11L)
				.append(11)
				.append(true)
				.append(1.1d)
				.append(1.1f)
		;


	}
}
