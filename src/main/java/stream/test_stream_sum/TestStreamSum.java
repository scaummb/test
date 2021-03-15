package stream.test_stream_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/7/28 12:14
 */

public class TestStreamSum {
	public static void main(String[] args) {
		Integer[] integerArray = getList();
		List<Integer> list = new ArrayList<>(Arrays.asList(integerArray));
		System.out.println("1 " + System.currentTimeMillis());
		IntSummaryStatistics summaryStatistics = list.stream().mapToInt((s) -> s).summaryStatistics();
		System.out.println("2 " + System.currentTimeMillis() + " 总和：" + summaryStatistics.getSum());
		int b = 0;
		for (int a : integerArray) {
			b += a;
		}
		System.out.println("3 " + System.currentTimeMillis() + " 总和：" + b);
		System.out.println("平均数：" + summaryStatistics.getAverage());
		System.out.println("总个数：" + summaryStatistics.getCount());
		System.out.println("最大值：" + summaryStatistics.getMax());
		System.out.println("最小值：" + summaryStatistics.getMin());
	}

	private static Integer[] getList() {
		Integer[] arrays = new Integer[10000];
		for (int i = 0; i < 10000; i++) {
			arrays[i] = i;
		}
		return arrays;
	}
}
