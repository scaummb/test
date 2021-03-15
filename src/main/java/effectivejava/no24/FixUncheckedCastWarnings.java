package effectivejava.no24;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/11/23 07:39
 */

public class FixUncheckedCastWarnings {

	private static final int SIZE = 12;
	private static T[] elements;

	public static void main(String[] args) {
		Set<Lark> exaltation = new HashSet();
		Set<Lark> exaltation1 = new HashSet<Lark>();
	}

	public static <T> T[] toArray(T[] a) {
		if (a.length < SIZE) {
			// 这个强制转换是正确的，因为创建的数组是和传入的数组类型一致的，使用了泛型参数列表 T[]
			@SuppressWarnings("unchecked")
			T[] result = (T[]) Arrays.copyOf(elements, SIZE, a.getClass());
			return result;
		}
		System.arraycopy(elements, 0, a, 0, SIZE);
		if (a.length > SIZE) {
			a[SIZE] = null;
		}
		return a;
	}

}

class Lark {
}
