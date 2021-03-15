package collection;

import collection.testComparatorAndCollectionUtils.User;
import collection.testComparatorAndCollectionUtils.UserComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 比较工具类两种排序方法的性能
 * 1、 Collections.sort(Collection<?>) 默认升序
 * 2、 Collections.sort(Collection<?>, Comparator())
 * 数据量10000000,1优于2，数据量1000,1优于2
 * <p>
 * 底层原因：实现了Comparator的比较器可以完成自定义排序规则，增加了灵活度
 * </p>
 *
 * @author momoubin
 * @date 2020/5/5
 */
public class TestComparatorAndCollectionUtils {
	private static final Long LIMIT_SIZE = 10000L;

	public static void main(String[] args) {
		List users = init();
		List user2 = init();

		long start = System.currentTimeMillis();
		System.out.println("start:" + start);
		Collections.sort(users);
		System.out.println("sort without comparator, end:" + (System.currentTimeMillis()) + " cost:" + (System.currentTimeMillis() - start));

		start = System.currentTimeMillis();
		Collections.sort(user2, new UserComparator());
		System.out.println("sort with comparator,end:" + (System.currentTimeMillis()) + " cost:" + (System.currentTimeMillis() - start));
	}

	private static List init() {
		ArrayList<User> users = new ArrayList();
		Long i = LIMIT_SIZE;
		do {
			Long age = new Random().nextLong();
			User user = new User(age);
			users.add(user);
			i--;
		} while (i > 0);
		return users;
	}
}
