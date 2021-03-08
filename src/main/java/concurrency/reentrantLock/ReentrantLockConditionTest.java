package concurrency.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *     用ReentrantLock绑定三个条件实现线程A打印一次1，线程B打印两次2，线程C打印三次3
 *     打印不同内容。
 *
 * </p>
 * @author moubin.mo
 * @date: 2021/3/6 18:25
 */

public class ReentrantLockConditionTest {
	public static void main(String[] args) {
		Resource resource = new Resource();
		new Thread(()->{
			for (int i = 1; i <= 2; i++){
				resource.print1();
			}
		}, "A").start();
		new Thread(()->{
			for (int i = 1; i <= 2; i++){
				resource.print2();
			}
		}, "B").start();
		new Thread(()->{
			for (int i = 1; i <= 2; i++){
				resource.print3();
			}
		}, "C").start();
	}
}
class Resource{
	private int number = 1;//A:1 B:2 C:3
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	private Condition c4 = lock.newCondition();

	public void print1(){
		lock.lock();

		try {
			while (number != 1){
				c1.await();
			}

			//2 do sth
			for (int i = 1; i < 2; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number);
			}

			//3 通知
			number = 2;
			c2.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print2(){
		lock.lock();

		try {
			while (number != 2){
				//在被信号唤醒或者中断之前，都会一直阻塞
				c2.await();
			}
			//2 do sth
			for (int i = 1; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number);
			}
			// 3唤醒c3
			number = 3;
			c3.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	//1 判断
	public void print3() {

		lock.lock();

		try {
			//判断
			while (number != 3) {
				c3.await();
			}
			//2 do sth
			for (int i = 1; i < 4; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + number);
			}

			//3 通知
			number = 1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}