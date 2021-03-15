package stream.test_stream_map;

import stream.Female;
import stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 之 map使用测试
 *
 * @author moubin.mo
 * @date: 2019/9/15 11:43
 */

public class TestStreamMap {
	public static void main(String[] args) {
		List<Person> persons = getList();

		// 找到所有女性
		Stream<Female> femaleStream = persons.stream()
				.filter(person -> person.getGender().equals((byte) 2))
				.map(
						r -> {
							return new Female(r.getAge(), r.getName(), r.getHeight(), r.getWeight(), r.getNation(), r.getGender());
						}
				);

		List<Female> females = femaleStream.collect(Collectors.toList());
		females.stream().forEach(r -> {
					System.out.println(r);
				}
		);

		// 找到所有中国人
		Stream<Person> personStream = persons.stream()
				.filter(person -> person.getNation().equals(1))
				.map(
						r -> {
							return new Person(r.getAge(), r.getName(), r.getHeight(), r.getWeight(), r.getNation(), r.getGender());
						}
				);
		List<Person> chinese = personStream.collect(Collectors.toList());
		chinese.forEach(
				r -> {
					System.out.println(r);
				}
		);
		long count = chinese.size();
		System.out.println("中国人数：" + count);

	}

	public static List<Person> getList() {
		//(Integer age, String name, Integer height, Integer weight, Integer nation, Byte gender)
		Person zhenzhihui = new Person(23, "zhenzhihui", 156, 66, 1, (byte) 1);
		Person zhiguhui = new Person(23, "zhiguhui", 156, 66, 2, (byte) 1);
		Person inno = new Person(23, "inno", 156, 66, 2, (byte) 2);
		Person kailin = new Person(23, "kailin", 156, 66, 2, (byte) 1);
		Person gangwanyihao = new Person(23, "gangwanyihao", 156, 66, 1, (byte) 2);
		ArrayList<Person> projects = new ArrayList<>();
		projects.add(zhenzhihui);
		projects.add(zhiguhui);
		projects.add(inno);
		projects.add(kailin);
		projects.add(gangwanyihao);
		return projects;
	}

}
