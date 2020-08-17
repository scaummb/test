package jvm.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * <p>
 *     软引用：当内存不足时，才会触发JVM进行GC回收。
 *     	适合做缓存。
 * </p>
 * @author moubin.mo
 * @date: 2020/8/18 00:18
 */

public class SoftReferenceObject {
	public static void main(String[] args) {
		SoftReference<SoftReferenceObject> softReference = new SoftReference<>(new SoftReferenceObject());
		System.out.println(softReference);
		System.gc();
		System.out.println(softReference);
		ArrayList<Object> objects = new ArrayList<>();
		for (int i=0; i<10; i++){
			objects.add(new SoftReferenceObject());
		}
		System.gc();
		System.out.println(softReference);
	}
}
