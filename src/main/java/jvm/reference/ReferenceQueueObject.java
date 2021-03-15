package jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * <p>
 * 虚引用/幻影引用：
 * 1）无法通过虚引用获取对一个对象的真实引用
 * 2）虚引用必须通过与 PhantomReference 组合一起使用。当GC	回收一个对象，发现它还有虚引用，就会在回收前把这个引用加到与之关联的ReferenceQueue中
 * NIO运用到它管理堆外存。
 * </p>
 *
 * @author moubin.mo
 * @date: 2020/8/18 00:23
 */

public class ReferenceQueueObject {
	public static void main(String[] args) {
		ReferenceQueue referenceQueue = new ReferenceQueue();
		PhantomReference<byte[]> reference = new PhantomReference<byte[]>(new byte[1], referenceQueue);
		System.out.println(reference.get());
	}
}
