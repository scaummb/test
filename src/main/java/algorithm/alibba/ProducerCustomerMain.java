package algorithm.alibba;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 *     实现一个生产者、消费者场景。假设现在有一个任务调度系统负责处理数据，A线程负责从DB里拉待处理的任务放到队列；B线程组负责从队列中处理任务；由于任务处理量较大，
 * 所以B线程会将任务进行拆分子线程并行处理。当所有子线程处理完成后，由B线程汇总结果并统一落库。
 * 要求：
 * 1、A线程组负责生产数据data；
 * 2、B线程组负责消费data数据；A、B线程组要实现阻塞；请尽量考虑异常场景的处理；
 * 3、B线程组的一个处理线程在获取到一个数据后，需要再拆分5个子线程并行处理数据，当5个子线程全部处理完成，B的处理线程将结果合并；请尽量考虑异常场景的处理；
 * </p>
 */
public class ProducerCustomerMain {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> dataQueue = new ArrayBlockingQueue<>(20); //数据队列，容量20
        ExecutorService threadPool = Executors.newCachedThreadPool();  //线程池

        System.out.println("生产者线程组启动");
        //生产者线程启动
        for(int i=0 ;i<7;i++){
            threadPool.submit(new Producer(dataQueue));
        }

        System.out.println("消费者线程组启动");
        //消费者线程启动
        for(int i=0 ;i<3;i++){
            threadPool.submit(new Customer(dataQueue));
        }

        threadPool.shutdown();
    }


    /**
     * 生产者线程
     */
    static class Producer implements Callable<Integer> {

        /**
         * 数据队列
         */
        ArrayBlockingQueue<Integer> dataQueue;

        public Producer(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public Integer call() throws Exception {
            int data = (int) (Math.random() * 10);  //随机生成数据
            dataQueue.put(data);   //放入数据队列中
            System.out.println("生产线程-"+Thread.currentThread().getName()+"生成数据:"+data );
            return data;
        }
    }


    /**
     * 消费者线程
     */
    static class Customer implements Callable<Integer> {

        /**
         * 数据队列
         */
        ArrayBlockingQueue<Integer> dataQueue;

        public Customer(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public Integer call() throws Exception {
            while(true){  //循环消费处理数据
                int data = dataQueue.take();  //从数据队列中取数据
                System.out.println("消费线程-"+Thread.currentThread().getName()+"获取到待处理数据:"+data);
                try{
                    int result = dispiseData(data);
                    System.out.println("消费线程-"+Thread.currentThread().getName()+"处理数据"+data +"的结果为:"+result);  //正常处理结果
                }catch (Exception e){
                    System.out.println("消费线程-"+Thread.currentThread().getName()+"处理数据"+data +"出错,原因为:"+e); //异常处理
                }
            }
        }


        /**
         * 处理数据（从数据队列中获取得到的）
         * @param data
         * @return
         * @throws Exception
         */
        Integer dispiseData(Integer data) throws Exception{
            ExecutorService es = Executors.newFixedThreadPool(5);  //生成处理线程线池（5个线程）
            List<Callable<Integer>> cdCallList = new ArrayList<>();  //处理线程 5个
            for (int i = 0; i<5 ; i++){
                cdCallList.add(new CustomerDispose(data));
            }
            List<Future<Integer>> resultFutures = es.invokeAll(cdCallList); //处理结束获取结果  5个future
            int result = 0;  //结果
            for(Future<Integer> t : resultFutures){  //计算处理结果
                result += t.get();
            }
            es.shutdown();
            return result;
        }
    }

    /**
     * 消费者处理线程2w
     */
    static class CustomerDispose implements Callable<Integer> {

        /**
         * 待处理的数据
         */
        private Integer data;

        public CustomerDispose(Integer data) {
            this.data = data;
        }

        @Override
        public Integer call() throws Exception {
            return doDisposeData(data);
        }

        /**
         * 处理数据 （获取数据+1）
         *
         * @param data
         * @return
         */
        Integer doDisposeData(Integer data) {
//            if(Math.random()>0.8){  //随机产生异常
//                throw new RuntimeException("produce error");
//            }
            return data + 1;
        }

    }
}