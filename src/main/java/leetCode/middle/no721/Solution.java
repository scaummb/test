package leetCode.middle.no721;

import java.util.*;

/**
 * @author moubin.mo
 * @date: 2021/1/18 15:10
 */

class Solution {
	public static void main(String[] args) {
		List<List<String>> restult = new ArrayList<>();
		List<String> test = new ArrayList<>();
		test.add("John");
		test.add("johnsmith@mail.com");
		test.add("john00@mail.com");
		List<String> test1 = new ArrayList<>();
		test1.add("John");
		test1.add("johnnybravo@mail.com");
		List<String> test2 = new ArrayList<>();
		test2.add("John");
		test2.add("johnsmith@mail.com");
		test2.add("john_newyork@mail.com");
		List<String> test3 = new ArrayList<>();
		test3.add("John");
		test3.add("mary@mail.com");

		restult.add(test);
		restult.add(test1);
		restult.add(test2);
		restult.add(test3);
		List<List<String>> lists = accountsMerge(restult);
		System.out.println(Arrays.asList(lists));
	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		ArrayList<Integer> mergeIndexs = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		// 遍历list
		for (int begin = 0; begin < accounts.size() && !mergeIndexs.contains(begin); begin++) {
			List<String> emails = accounts.get(begin).subList(1, accounts.get(begin).size());
			for (String email : emails) {
				// 遍历第一个list的所有元素，在之后的list中是否存在
				int index = checkEmailRepeat(begin, mergeIndexs, email, accounts);
				if (begin != index) {
					mergeIndexs.add(index);
					mergeIndexs.add(begin);
					mergeAccounts(begin, index, accounts, result);
					break;
				}
			}

		}
		//整合数据
		addElements(result, accounts, mergeIndexs);
		return sortResult(result);
	}

	private static List<List<String>> sortResult(List<List<String>> accounts) {
		HashMap hashMap = new HashMap();
		for (int a = 0; a < accounts.size(); a++) {
			hashMap.put(accounts.get(a).get(0), a);
		}
		List<String> arrayList = new ArrayList(hashMap.keySet());
		Collections.sort(arrayList);
		List<List<String>> result = new ArrayList<>();
		for (String key : arrayList) {
			result.add(accounts.get((Integer) hashMap.get(key)));
		}
		return result;
	}

	private static void addElements(List<List<String>> result, List<List<String>> accounts, ArrayList<Integer> mergeIndexs) {
		for (int a = 0; a < accounts.size(); a++) {
			if (!mergeIndexs.contains(a)) {
				result.add(accounts.get(a));
			}
		}
	}

	private static void mergeAccounts(int begin, int index, List<List<String>> accounts, List<List<String>> results) {
		TreeSet<String> emails = new TreeSet();
		List<String> emails1 = accounts.get(begin).subList(1, accounts.get(begin).size());
		List<String> emails2 = accounts.get(index).subList(1, accounts.get(begin).size());
		emails.addAll(emails2);
		emails.addAll(emails1);
		ArrayList<String> result = new ArrayList<>();
		result.addAll(emails);
		Collections.sort(result);
		result.add(0, accounts.get(begin).get(0));
		results.add(result);
	}

	private static int checkEmailRepeat(int begin, ArrayList<Integer> mergeIndexs, String email, List<List<String>> accounts) {
		for (int index = 0; index < accounts.size(); index++) {
			if (index != begin && !mergeIndexs.contains(index)) {
				List<String> emails = accounts.get(index).subList(1, accounts.get(index).size());
				if (emails.contains(email)) {
					return index;
				}
			}
		}
		return begin;
	}
}