package jvm.reference;

/**
 * <p>
 *     强引用：当对象指向内存为空不关联时，才会被GC回收，否则永远不会回收。
 * </p>
 * @author moubin.mo
 * @date: 2020/8/18 00:04
 * JVM参数：-Xmx2M -Xmn1M
 * 运行结果
 * Error occurred during initialization of VM
 * GC triggered before VM initialization completed. Try increasing NewSize, current value 1536K.
 * Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size of 1536k will be used.
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
