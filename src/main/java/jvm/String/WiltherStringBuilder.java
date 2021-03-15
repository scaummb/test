package jvm.String;

/**
 * <p>编译器底层优化，每次循环创建new 一个StringBuilder，java中预先使用StringBuilder，
 * 则可以指定长度，也可以避免重新分配内存</p>
 */
public class WiltherStringBuilder {
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			result += fields[i];
		}
		return result;
	}

	public String explict(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i]);
		}
		return result.toString();
	}
}
