package hashCode;

import java.util.Comparator;

/**
 * <p>日程排序比较器</p>
 *
 * @author moubin.mo
 * @date: 2020/3/10 09:01
 */

public class RemindComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		RemindDTO obj1 = (RemindDTO) o1;
		RemindDTO obj2 = (RemindDTO) o2;
		if (Long.compare(obj1.getStartTime(), obj2.getStartTime()) == 0) {
			return Long.compare(obj1.getEndTime(), obj2.getEndTime());
		}
		return Long.compare(obj1.getStartTime(), obj2.getStartTime());
	}
}
