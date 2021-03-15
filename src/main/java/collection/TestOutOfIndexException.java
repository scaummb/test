package collection;

import Utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author momoubin
 * @date 2020/5/5
 */
public class TestOutOfIndexException {
	private static final Integer pageNum = 1;
	private static final Integer pageSize = 20;

	public static void main(String[] args) {
		List<Long> list = init();
		ListAllDepartmentsResponse response = new ListAllDepartmentsResponse();
		if (list.size() >= ((pageNum * pageSize))
				&& list.get((pageNum * pageSize)) != null) {
			response.setNextPageNum(pageNum + 1);
		}
		if (list.size() >= ((pageNum * pageSize))) {
			response.setDtos(list.subList((pageNum - 1) * pageSize, pageNum * pageSize));
		} else {
			response.setDtos(list.subList((pageNum - 1) * pageSize, list.size()));
		}

		PrintUtils.printObjects(response);
	}

	private static List<Long> init() {
		ArrayList<Long> list = new ArrayList<>();
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(1111L);
		list.add(2222L);
		return list;
	}
}

class ListAllDepartmentsResponse {
	private List<Long> dtos;
	private Integer nextPageNum;

	public List<Long> getDtos() {
		return dtos;
	}

	public void setDtos(List<Long> dtos) {
		this.dtos = dtos;
	}

	public Integer getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(Integer nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
}