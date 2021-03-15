package concurrency.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author moubin.mo
 * @date: 2021/3/12 23:36
 */

public class SpinLockTest {
	AtomicReference<Thread> reference = new AtomicReference<>();

	//加锁
	public void mylock(){
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " try to get lock..");
		//工具类提供了CAS操作
		while (!reference.compareAndSet(null,thread)){
			//do nothing CPU 空转（自旋）
//			System.out.println(thread.getName() + " cannot get the lock, so do nothing and waiting...");
		}
	}

	//解锁
	public void unlock(){
		Thread thread = Thread.currentThread();
		reference.compareAndSet(thread,null);
		System.out.println(thread.getName()+ " to release lock.");
	}

	public static void main(String[] args) {
		SpinLockTest spinLockTest = new SpinLockTest();
		new Thread(()->{
			spinLockTest.mylock();
			try {
				TimeUnit.SECONDS.sleep(5);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			//休眠10s之后，t1 才释放锁(未释放资源期间，其他的线程会一直空转)
			spinLockTest.unlock();
		},"t1").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		new Thread(()->{
			//t2 启动并且申请锁 & t2 释放锁资源
			spinLockTest.mylock();
			spinLockTest.unlock();
		},"t2").start();
	}
}
