package jvm.reference;

import java.lang.ref.WeakReference;

/**
 * <p>
 *     弱引用：无论内存是否足够，都会被GC回收
 * </p>
 * @author moubin.mo
 * @date: 2020/8/18 00:11
 */

public class WeakReferenceObject {

	public static void main(String[] args) {
		WeakReference weakReference = new WeakReference(new long[1024*1024]);
		System.out.println(weakReference.get());
		System.gc();
		System.out.println(weakReference.get());
	}
}
