package collection;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author moubin.mo
 * @date: 2020/9/8 18:25
 */

public class TestSortCollection {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new People(null));
		list.add(new People(null));
		list.add(new People(null));
		list.add(new People(11));
		Collections.sort(list, new PeopleComparator());
	}


	static class PeopleComparator implements Comparator<People>{

		@Override
		public int compare(People dto1, People dto2) {
			if (!ObjectUtils.isEmpty(dto1) && !ObjectUtils.isEmpty(dto1.getAge())
					&& !ObjectUtils.isEmpty(dto2) && !ObjectUtils.isEmpty(dto2.getAge())){
				return dto1.getAge().compareTo(dto2.getAge());
			}
			return 0;
		}
	}
	static class People{
		private Integer age;

		public People(Integer age) {
			this.age = age;
		}

		public People() {
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
	}

}
