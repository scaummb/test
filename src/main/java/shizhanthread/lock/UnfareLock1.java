package shizhanthread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfareLock1 {
    //隐式锁Lock
    public static void main(String[] args) {
        Runnable run = new Tickted();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Tickted implements Runnable{
        //总票数
        private int count = 10;
        //创建一把隐式锁
        //传入参数true表示公平锁（ new NonfairSync(); 默认是不公平）
        private Lock l = new ReentrantLock();
        @Override
        public void run() {
            while (true){
                //锁住
                l.lock();
                if (count > 0){
                    System.out.println("开始卖票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count --;
                    System.out.println(Thread.currentThread().getName() + "卖票成功 余票为:" + count);
                }else {
                    break;
                }
                //开锁
                l.unlock();
            }
        }
    }
}

