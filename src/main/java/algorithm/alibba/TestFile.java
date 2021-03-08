package algorithm.alibba;

import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.commons.lang.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * <p>
 *     集合，IO流的操作，Stream，线程池，线程工具的使用
 * </p>
 */
public class TestFile {
	private final static CopyOnWriteArrayList<TreeSet> treeSetList = new CopyOnWriteArrayList();
	private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), new NamedThreadFactory("testFile"));

	public static void main(String[] args) throws InterruptedException {
		String fileName = "/test.txt";
		System.out.println(sortFile(fileName));
	}

	private static String sortFile(String fileName) throws InterruptedException {
		int lineNums = getFileLineNum(fileName);

		Map dataRange = new LinkedHashMap<Integer,Integer>();

		//10 * 1024 * 1024 * 1024 = 10G,每行1k，有 10*1024*1024行数据，大约10000000多行
		//设置每个线程处理50000行，需要1000个线程
		int maxPageSize = 50000;

		//翻页起始
		for (int i = 0; i < lineNums; i += maxPageSize){
			dataRange.put(i, Math.min(i + maxPageSize, lineNums));
		}

		CountDownLatch countDownLatch = new CountDownLatch(dataRange.size());

		Set<Integer> keySets = dataRange.keySet();
		for (Integer start : keySets){
			int startlineNo = start + 1;
			int pageSize = (Integer) dataRange.get(start) - startlineNo;
			//提交任务
			executor.submit(new SortTask(countDownLatch, fileName, startlineNo, pageSize));
		}

		countDownLatch.await();

		TreeSet treeSet = new TreeSet<>(Comparator.reverseOrder());
		for (TreeSet datas : treeSetList){
			treeSet.addAll(datas);
		}

		Stream stream = treeSet.stream().limit(10);
		return StringUtils.join(stream.toArray(), ",");
	}

	private static int getFileLineNum(String fileName) {
		try{
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName));
			lineNumberReader.skip(Long.MAX_VALUE);
			int lineNumber = lineNumberReader.getLineNumber();
			return lineNumber + 1;
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e) {
			return -1;
		}
	}

	/**
	 * <p>
	 *
	 * </p>
	 */
	private static TreeSet sortFileStream(Stream<String> lines) {
		TreeSet<Integer> list = new TreeSet<>();
		lines.forEach(line -> {
			if (StringUtils.isNotEmpty(line)){
				String[] lineDatas = line.split("\\s");
				for (String data : lineDatas){
					int data1 = Integer.parseInt(data);
					list.add(data1);
					if (list.size()>10){
						list.pollFirst();
					}
				}
			}
		});
		return list;
	}

	//task
	static class SortTask implements Runnable{
		private CountDownLatch countDownLatch;
		private String fileName;
		private int startLine;
		private int pageSize;

		public SortTask(final CountDownLatch countDownLatch, final String fileName, final int startLine, final int pageSize) {
			this.countDownLatch = countDownLatch;
			this.fileName = fileName;
			this.startLine = startLine;
			this.pageSize = pageSize;
		}

		@Override
		public void run() {
			try {
				LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName));

				//设置读取的开始行号
				lineNumberReader.setLineNumber(startLine);

				//读取行数（数据流）
				Stream<String> lines = lineNumberReader.lines().limit(pageSize);
				TreeSet treeSet = sortFileStream(lines);
				treeSetList.add(treeSet);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
			}
		}

	}
}
