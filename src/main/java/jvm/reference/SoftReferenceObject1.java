package jvm.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 软引用：当内存不足时，才会触发JVM进行GC回收。
 * 适合做缓存。
 * </p>
 */

public class SoftReferenceObject1 {

	public static void main(String[] args) {
		softRefenceTest();
	}

	/**
	 * 仅仅gc， 还不会回收。需内存不够 GC的时候才回收软引用。
	 * 启动参数：
	 * -Xmx16m  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:NewSize=2m -XX:MaxNewSize=2m
	 */
	private static void softRefenceTest() {
		final int _8M = 8 * 1024 * 1024;
		List<SoftReference> list = new ArrayList<SoftReference>();
		System.out.println("add 8m  -1");
		list.add(new SoftReference(new byte[_8M]));
		System.out.println("add 8m  -2");
		list.add(new SoftReference(new byte[_8M]));
		System.out.println("add 8m  -3");
		list.add(new SoftReference(new byte[_8M]));
		System.out.println("add 8m  -4");
		list.add(new SoftReference(new byte[_8M]));
		System.out.println("add 8m  -5");
		list.add(new SoftReference(new byte[_8M]));
		System.out.println("add 8m  -6");
		list.add(new SoftReference(new byte[_8M]));
		System.gc();
		list.stream().forEach(r -> System.out.println(r.get()));
	}

	/**
	 * 软引用手动gc ，由于内存足够，不会回收软引用对应的内存
	 *
	 * @throws InterruptedException
	 */
	private static void softReferenceGCByManual() throws InterruptedException {
		final int _1M = 1 * 1024 * 1024;//直接改为1M测试
		List<SoftReference> list = new ArrayList<SoftReference>();
		System.out.println("add 1m  -1");
		list.add(new SoftReference(new byte[_1M]));
		System.out.println("add 1m  -2");
		list.add(new SoftReference(new byte[_1M]));
		System.out.println("add 1m  -3");
		list.add(new SoftReference(new byte[_1M]));
		System.gc();//内存足够，不会回收软引用对应的内存
		System.out.println("gc---");
		TimeUnit.SECONDS.sleep(1);
		list.stream().forEach(r -> System.out.println(r.get()));
	}

}
