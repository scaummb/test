package enum_test;

import Utils.PrintUtils;

/**
 * <p>创建 enum 时，编译器会自动补充 ordinal() 方法</p>
 *
 * @author momoubin
 * @date 2020/5/4
 */
public class EnumOrder {
	public static void main(String[] args) {
		for (Spiciness s : Spiciness.values()) {
			PrintUtils.printObjects(s + ", odinal " + s.ordinal());
		}
	}
}
