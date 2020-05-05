package collection.testComparatorAndCollectionUtils;

import java.util.Comparator;

/**
 * @author momoubin
 * @date 2020/5/5
 */
public class UserComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        User user1 = (User) o1;
        User user2 = (User) o2;
        return Long.compare(user1.getAge(), user2.getAge());
    }
}
