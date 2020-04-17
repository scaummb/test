package compare;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author moubin.mo
 * @date: 2020/4/8 17:29
 */

public class ComparatorTest {
	public static void main(String[] args) {
		ArrayList<DTO> list = new ArrayList(){{
			add(new DTO(323));
			add(new DTO(322));
			add(new DTO(320));
			add(new DTO(325));
		}};
		Collections.sort(list, new DTOComparator());
		list.stream().forEach(dto -> {System.out.println(dto.getSortNum());});
	}
}
