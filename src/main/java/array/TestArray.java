package array;

/**
 * 数组也可以装复杂对象
 * {
 * 数组元素可以是任何类型（只要所有元素具有相同的类型）
 * 数组元素可以是基本数据类型
 * 数组元素也可以是类对象，称这样的数组为对象数组。
 * 在这种情况下，数组的每一个元素都是一个对象的引用。
 * }
 *
 * @author moubin.mo
 * @date: 2019/9/15 15:38
 */

public class TestArray {
	public static void main(String[] args) {
		// 静态初始化：在定义数组的同时对数组元素进行初始化
		BankAccount[] accounts = {new BankAccount("Zhang", 100.00),
				new BankAccount("Li", 2380.00),
				new BankAccount("Wang", 500.00),
				new BankAccount("Liu", 175.56),
				new BankAccount("Ma", 924.02)
		};
		int[] a = new int[]{11, 23, 44, 55};
		Integer[] b = new Integer[]{11, 22, 33, 44};

		// 动态初始化：使用运算符new为数组分配空间，对于基本类型的数组.
		// 对于对象数组，使用运算符new只是为数组本身分配空间，并没有对数组的元素进行初始化。即数组元素都为空
		String arrayName[] = new String[33];
	}
}
