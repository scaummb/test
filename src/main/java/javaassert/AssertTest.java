package javaassert;

/**
 * <p>
 * 断言使用：
 * 1、assert <boolean表达式>:
 * 如果<boolean表达式>为true，则程序继续执行。
 * 如果为false，则程序抛出AssertionError，并终止执行。
 * 2、assert <boolean表达式>: <错误信息表达式>
 * 如果<boolean表达式>为true，则程序继续执行。
 * 如果为false，则程序抛出java.lang.AssertionError，并输入<错误信息表达式>。
 * 风险：assert断言失败将面临程序的退出。这在一个生产环境下的应用是绝不能容忍的。一般都是通过异常处理来解决程序中潜在的错误。但是使用断言就很危险，一旦失败系统就挂了。
 * 使用断言的前提是配置虚拟机参数设置开启断言：VM Argurments：-ea
 * </p>
 *
 * @author moubin.mo
 * @date: 2020/6/7 12:59
 */

public class AssertTest {
	public static void main(String[] args) {
		Integer code = 11;
		assert 1 > 2;
		System.out.println("true");
//		assert(!ObjectUtils.isEmpty(code));

		assert true;
		assert false;


	}
}
