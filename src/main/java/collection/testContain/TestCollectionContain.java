package collection.testContain;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/11/20 16:21
 */

public class TestCollectionContain {
	public static void main(String[] args) {
//		List<Long> disAbleCommuntyIds = new ArrayList(){{add(1L);add(2L);add(3L);}};
		List<Long> disAbleCommuntyIds = new ArrayList() {{
			add(1L);
			add(2L);
		}};
		List<Long> communtyIds = new ArrayList() {{
			add(1L);
		}};
		System.out.println(checkDisableCommuntyIds(disAbleCommuntyIds, communtyIds));
	}

	private static boolean checkDisableCommuntyIds(List<Long> disAbleCommuntyIds, List<Long> communtyIds) {
		return (!CollectionUtils.isEmpty(disAbleCommuntyIds) && !CollectionUtils.isEmpty(communtyIds) && disAbleCommuntyIds.containsAll(communtyIds));
	}
}
