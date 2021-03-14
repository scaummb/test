//可以加注释，比package还前面
package jvm.instrument;
//import得在package后面

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2021/3/14 15:10
 */
public class TestCommand {
	public static void main(String[] args) throws InterruptedException {
		testJSTACK();
	}

	/**
	 * jstack 指令
	 * 		用于生成线程堆栈
	 */
	private static void testJSTACK() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++){
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 *     jmap 指令
	 *     		获取dump文件，还能查询 finalize 执行队列、Java 堆和永久代的信息（空间使用率&GC收集器等）
	 * </p>
	 */
	private static void testJMAP() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++){
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 *     jinfo 指令
	 *     		可以实时查看和调整虚拟机的各项参数​
	 *     案例：
	 * </p>
	 */
	private static void testJINFO() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++){
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 *     jstat 指令
	 *     案例：
	 *     		启动参数：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
	 *     		内存最终溢出OOM，此时通过jstat可以观察到进行了8次YGC，1次FGC
	 * </p>
	 */
	private static void testJSTAT() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		ArrayList<Integer> objects2 = new ArrayList<>();
		for (int i = 0; i < 10000000; i++){
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			objects2.addAll(objects);
			if (i > 830){
				Thread.sleep(100);
			}
		}
	}

	/**
	 * <p>
	 *     jps 指令
	 * </p>
	 */
	private static void testJPS() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 10000000; i++){
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}
}
