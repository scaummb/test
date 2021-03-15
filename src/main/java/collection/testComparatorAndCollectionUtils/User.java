package collection.testComparatorAndCollectionUtils;

/**
 * @author momoubin
 * @date 2020/5/5
 */
public class User implements Comparable {
	private Long age;

	public User(Long age) {
		this.age = age;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Override
	public int compareTo(Object o) {
		User obj = (User) o;
		return Long.compare(age, obj.getAge());
	}
}
