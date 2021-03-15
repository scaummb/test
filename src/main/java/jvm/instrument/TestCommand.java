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
		testJCONSOLE_DeadLock();
	}

	/**
	 * <p>
	 *		案例：死锁演示
	 * </p>
	 */
	private static void testJCONSOLE_DeadLock() {
		for (int i = 0; i <100; i++){
			new Thread(new SynAddRunnable(1,2)).start();
			new Thread(new SynAddRunnable(2,1)).start();
		}
	}
	/**
	 * <p>
	 *     线程死锁等待演示
	 * </p>
	 */
	static class SynAddRunnable implements Runnable{
		int a,b;
		public SynAddRunnable(final int a, final int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)){
				synchronized (Integer.valueOf(b)){
					System.out.println(a + b);
				}
			}
		}
	}

	/**
	 *  JConsole 可视化监控
	 *  启动配置：-Xms100m -Xmx100m -XX:+UseSerialGC
	 *  -Dcom.sun.management.jmxremote  -Dcom.sun.management.jmxremote.port=8077
	 *  -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false
	 *  案例：
	 *  	每50ms一次往Java堆填充64Kb数据，一共1000次
	 */
	private static void testJCONSOLE() throws InterruptedException {
		ArrayList<OOMObject> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++){
			//延时一段时间，让监控曲线变得明显。
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}

	/**
	 * 内存占位符对象，一个对象 64KB
	 */
	static class OOMObject{
		public byte[] placeholder = new byte[64*1024];
	}

	/**
	 * jstack 指令
	 * 用于生成线程堆栈
	 * 配置：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
	 */
	private static void testJSTACK() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 * jmap 指令
	 * 获取dump文件，还能查询 finalize 执行队列、Java 堆和永久代的信息（空间使用率&GC收集器等）
	 * 配置：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
	 * </p>
	 */
	private static void testJMAP() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 * jinfo 指令
	 * 可以实时查看和调整虚拟机的各项参数​
	 * 配置：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
	 * 案例：
	 * </p>
	 */
	private static void testJINFO() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}

	/**
	 * <p>
	 * jstat 指令
	 * 案例：
	 * 启动参数：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
	 * 内存最终溢出OOM，此时通过jstat可以观察到进行了8次YGC，1次FGC
	 * </p>
	 */
	private static void testJSTAT() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		ArrayList<Integer> objects2 = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			objects2.addAll(objects);
			if (i > 830) {
				Thread.sleep(100);
			}
		}
	}

	/**
	 * <p>
	 * jps 指令
	 * </p>
	 */
	private static void testJPS() throws InterruptedException {
		ArrayList<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			Integer integer = new Integer(i);
			objects.add(integer);
			System.out.println("sleeping.. i = " + i);
			Thread.sleep(100);
		}
	}
}
