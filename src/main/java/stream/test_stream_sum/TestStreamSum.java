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
		Integer[] integerArray = {1, 3, 5, 10, 18};

		List<Integer> list = new ArrayList<>(Arrays.asList(integerArray));

		IntSummaryStatistics summaryStatistics = list.stream().mapToInt((s) -> s).summaryStatistics();

		System.out.println("总和：" + summaryStatistics.getSum());
		System.out.println("平均数：" + summaryStatistics.getAverage());
		System.out.println("总个数：" + summaryStatistics.getCount());
		System.out.println("最大值：" + summaryStatistics.getMax());
		System.out.println("最小值：" + summaryStatistics.getMin());
	}
}
