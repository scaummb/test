package hashCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Date: 2019/7/28 15 :11
 *
 * @author moubin.mo
 */

public class TestSort {
	public static void main(String[] args) {
		RemindDTO remindDTO1 = new RemindDTO(1L, 2L);
		RemindDTO remindDTO2 = new RemindDTO(2L, 2L);
		RemindDTO remindDTO3 = new RemindDTO(3L, 2L);
		RemindDTO remindDTO4 = new RemindDTO(4L, 2L);
		RemindDTO remindDTO5 = new RemindDTO(4L, 4L);
		RemindDTO remindDTO6 = new RemindDTO(4L, 1L);
		testArrayList(remindDTO1, remindDTO2, remindDTO3, remindDTO4, remindDTO5, remindDTO6);
	}

	private static void testArrayList(RemindDTO... dtos) {
		ArrayList<RemindDTO> list = new ArrayList<>();
		for (RemindDTO dto : dtos) {
			list.add(dto);
		}

		list.stream().forEach(
				remindDTO -> System.out.println(remindDTO)
		);

		System.out.println("------------");

		Collections.sort(list, new RemindComparator());
		list.stream().forEach(
				remindDTO -> System.out.println(remindDTO)
		);
	}
}
