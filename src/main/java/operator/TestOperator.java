package operator;

import Utils.PrintUtils;

/**
 * <p>类型转换，如果是窄化转换，jvm会进行截尾和舍入</p>
 */
public class TestOperator {
	public static void main(String[] args) {
		double above = 0.7, below = 0.4;
		float fabove = 0.7f, fbelow = 0.4f;
		System.out.println(above);
		System.out.println((int) above);
	}
}
