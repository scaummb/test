package stream.test_stream_filter;

import com.alibaba.fastjson.JSON;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author moubin.mo
 * @date: 2020/6/7 19:38
 */

public class TestStreamFilter {
	public static void main(String[] args) {
		A a = new A(null, null);
		A a2 = new A("aa", "");
		A a3 = new A("bb", null);
		A a4 = new A("cc", null);
		ArrayList<A> list = new ArrayList();
		list.add(a);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		List<A> collect = list.stream().filter(aa -> !ObjectUtils.isEmpty(aa.getName())).collect(Collectors.toList());
		for (A aaa: collect){
			System.out.println(aaa.toString());
		}
	}
}

class A {
	private String name;
	private String age;

	public A(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}