//package algorithm.alibba;
//
//import org.apache.commons.lang.StringUtils;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.LineNumberReader;
//import java.util.Comparator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.TreeSet;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Stream;
//
///**
// * 一个大文件10G，里面一行行的数字(Integer, 空格分隔)，要找其中出最大的10个数字的值
// * 相同的数字算作一个，
// * 比如最大的数字是  20、10、13、20、3，则最大的3个数字是 20、13、10
// */
//public class BigFileSortUtil {
//
//    // 存储每个线程获取到的最大10个数字的数组
//    private static CopyOnWriteArrayList treeSetList = new CopyOnWriteArrayList<>();
//
//    private static ThreadPoolExecutor executor =
//            new ThreadPoolExecutor(
//                    10,
//                    1000,
//                    10L,
//                    TimeUnit.SECONDS,
//                    new ArrayBlockingQueue<>(500), new NameThreadFactory("BigFileSortUtil"));
//
//    public static void main(String[] args) throws InterruptedException {
//        String fileName = System.getProperty("user.dir") + "/test.txt";
//
//        System.out.println(sortFile(fileName));
//    }
//
//
//    public static String sortFile(String fileName) throws InterruptedException {
//        // 获取文件行数
//        int lineNumbers = getFileLineNum(fileName);
//
//        Map dataRange = new LinkedHashMap<>();
//
//        // 10GB=10*1024*1024*1024 bytes,假设每行是1KB，则有10*1024*1024行数据，大约10000000多行数据
//        // 设置每个线程处理10000行数据，则需要1000个线程
//        int maxPageSize = 50000;
//
//        // 每个线程处理的开始行和设计行
//        for (Integer i = 0; i < lineNumbers; i += maxPageSize) {
//            dataRange.put(i, Math.min(i + maxPageSize, lineNumbers));
//        }
//
//        CountDownLatch countDownLatch = new CountDownLatch(dataRange.size());
//        for (Map.Entry entry : dataRange.entrySet()) {
//            int startLine = entry.getKey() + 1;
//            int pageSize = entry.getValue() - entry.getKey();
//
//            // 提交任务到线程池
//            executor.submit(new SortRunnable(countDownLatch, fileName, startLine, pageSize));
//        }
//        countDownLatch.await();
//
//        // Set集合倒序，Set集合是去重集合
//        TreeSet treeSet = new TreeSet<>(Comparator.reverseOrder());
//        for (TreeSet datas : treeSetList) {
//            treeSet.addAll(datas);
//        }
//
//        // 获取Set集合前十个元素
//        try (Stream stream = treeSet.stream().limit(10)) {
//            return StringUtils.join(stream.toArray(), ",");
//        }
//
//    }
//
//    /**
//     * @return 最大的10个数字，带排序，格式比如：20、18、13、10、9、8、7、6、5、1
//     */
//    public static TreeSet sortFile(Stream lines) {
//        TreeSet list = new TreeSet<>();
//        // 按行取出数据
//        lines.forEach(line -> {
//            if (StringUtils.isNotBlank(line)) {
//                // 分割行数据，把数据放在固定大小的集合中
//                String[] lineDatas = line.split("\\s");
//
//                for (String lineData : lineDatas) {
//                    int data = Integer.parseInt(lineData);
//
//                    list.add(data);
//
//                    if (list.size() > 10) {
//                        list.pollFirst();
//                    }
//                }
//            }
//        });
//        return list;
//    }
//
//    public static int getFileLineNum(String fileName) {
//        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName))) {
//            lineNumberReader.skip(Long.MAX_VALUE);
//            int lineNumber = lineNumberReader.getLineNumber();
//            //实际上是读取换行符数量 , 所以需要+1
//            return lineNumber + 1;
//        } catch (IOException e) {
//            return -1;
//        }
//    }
//
//    private static class SortRunnable implements Runnable {
//
//        /**
//         * 线程计数器
//         */
//        private CountDownLatch countDownLatch;
//
//        /**
//         * 文件名称
//         */
//        private String fileName;
//
//        /**
//         * 文件读取的开始行数
//         */
//        private int startLine;
//
//        /**
//         * 读取的行数大小
//         */
//        private int pageSize;
//
//        public SortRunnable(CountDownLatch countDownLatch,
//                            String fileName,
//                            int startLine, int pageSize) {
//            this.countDownLatch = countDownLatch;
//            this.fileName = fileName;
//            this.startLine = startLine;
//            this.pageSize = pageSize;
//        }
//
//        @Override
//        public void run() {
//            try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName))) {
//
//                // 设置读取的开始行数
//                lineNumberReader.setLineNumber(startLine);
//
//                // 设置读取的行数大小
//                Stream lines = lineNumberReader.lines().limit(pageSize);
//
//                TreeSet treeSet = sortFile(lines);
//
//                treeSetList.add(treeSet);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                countDownLatch.countDown();
//            }
//        }
//    }
//
//    private static class NameThreadFactory implements ThreadFactory {
//
//        private final static AtomicInteger POOL_SEQ = new AtomicInteger();
//
//        private String prefix;
//
//        private ThreadGroup group;
//
//        private boolean demon = false;
//
//        public NameThreadFactory() {
//            this("pool-" + POOL_SEQ.getAndIncrement(), false);
//        }
//
//        public NameThreadFactory(String prefix) {
//            this(prefix, false);
//        }
//
//
//        public NameThreadFactory(String prefix, boolean demon) {
//            this.prefix = prefix + "-thread-";
//
//            SecurityManager securityManager = System.getSecurityManager();
//
//            ThreadGroup threadGroup = securityManager != null ? securityManager.getThreadGroup() : null;
//            this.group = threadGroup != null ? threadGroup : Thread.currentThread().getThreadGroup();
//
//            this.demon = demon;
//        }
//
//        @Override
//        public Thread newThread(Runnable runnable) {
//            String name = prefix + POOL_SEQ.getAndIncrement();
//            Thread thread = new Thread(group, runnable, name, 0);
//            thread.setDaemon(demon);
//            return thread;
//        }
//    }
//
//}