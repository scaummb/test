package stream.test_stream_groupby;

import stream.Female;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author moubin.mo
 * @date: 2020/11/19 16:06
 */

public class TestStreamGroupBy {
	public static void main(String[] args) {
		List<Female> females = new ArrayList(){{
			add(new Female(1, "1"));
			add(new Female(5, "3"));
			add(new Female(3, "3"));
			add(new Female(1, "2"));
			add(new Female(1, "3"));
			add(new Female(2, "3"));
			add(new Female(2, "4"));
			add(new Female(4, "3"));
			add(new Female(5, "5"));
		}};

		Map<Integer, List<String>> collect = females.stream().collect(Collectors.groupingBy(Female::getAge, LinkedHashMap::new, Collectors.mapping(Female::getName, Collectors.toList())));
//		Map<Integer, List<String>> collect = females.stream().collect(Collectors.groupingBy(Female::getAge, Collectors.mapping(Female::getName, Collectors.toList())));

		System.out.println(Arrays.asList(collect));

		females.stream().collect(Collectors.groupingBy(Female::getAge, Collectors.mapping(Female::getName, Collectors.toList())));


	}
}
