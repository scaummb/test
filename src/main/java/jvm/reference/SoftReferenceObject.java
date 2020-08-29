package jvm.reference;

import java.lang.ref.SoftReference;

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
		SoftReference<byte[]> softReference = new SoftReference<byte[]>(new byte[1024*1024*10]);
		System.out.println(softReference.get());
		System.gc();
		System.out.println("一次GC后，内存充足，" + softReference);
		byte[] bytes = new byte[1024 * 1024 * 5];
		System.out.println("重新分配10M内存后，堆内存不充足了，会触发软引用的对象被回收，" + softReference);
	}
}
