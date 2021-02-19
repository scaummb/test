package design_module.StrategyPattern;

/**
 * <p>
 *     Thread初始化，其实使用了策略模式，不管具体导出类（继承了Thread）是哪个对象，最终run方法被覆盖，策略不一样
 * </p>
 * @author moubin.mo
 * @date: 2020/6/7 21:00
 */

public class ThreadStrategy {
	public static void main(String[] args) {
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread2();
		thread1.start();
		thread2.start();
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		System.out.println("thread1.........");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		System.out.println("thread2.........");
	}
}
