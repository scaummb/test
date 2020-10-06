package effectivejava.no43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/10/4 11:38
 */

public class ReturnNullValue {
	private final List<Cheese> cheeseList = new ArrayList<>();
	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
	public Cheese[] getCheese(){
		// 返回空数组
		return cheeseList.toArray(EMPTY_CHEESE_ARRAY);
	}

	public List<Cheese> getCheeseList() {
		if (cheeseList.isEmpty()){
			// 返回一个不可变的空集合:emptySet/emptyMap/emptyList，这三个
			return Collections.emptyList();
		} else {
			return new ArrayList<Cheese>(cheeseList);
		}
	}

}
class Cheese{}