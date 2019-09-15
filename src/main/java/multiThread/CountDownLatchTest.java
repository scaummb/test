package multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author moubin.mo
 * @date: 2019/8/14 15:27
 */

public class CountDownLatchTest implements Runnable{

    private static String name ;

    private static final CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args){

        ExecutorService exec = Executors.newFixedThreadPool(1);
        for (int i=0; i<10; i++){
            exec.submit(new CountDownLatchTest(String.valueOf(i)));
        }

        // 等待检查
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        exec.shutdown();

    }

    @Override
    public void run() {
        System.out.println("value="+StaticClass.getName());
        latch.countDown();
    }

    public CountDownLatchTest(String name) {
        System.out.println("name="+name);
        StaticClass.setName(name);
    }
}
