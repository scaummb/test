package jvm.reference;

/**
 * <p>
 *     强引用：当对象指向内存为空不关联时，才会被GC回收，否则永远不会回收。
 * </p>
 * @author moubin.mo
 * @date: 2020/8/18 00:04
 */

public class ObjectReference {
	public static void main(String[] args) {
		String str = "StrongReference";
		System.out.println(str);
		System.gc();
		System.out.println(str);
		str = null;
		System.out.println(str);
	}
}
