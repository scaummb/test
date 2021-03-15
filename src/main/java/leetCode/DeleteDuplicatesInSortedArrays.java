package leetCode;

/**
 * Date: 2019/5/14 14 :32
 *
 * @author moubin.mo
 */

public class DeleteDuplicatesInSortedArrays {
	public static void main(String[] args) {
		// 1 2 2 3 3 4
		int[] array = {1, 2, 2, 2, 3, 3, 4};
//        int[] array = {1,1,2};
		int i = removeDuplicates(array);
		System.out.println("i=" + i);
		for (int j = 0; j < i; j++) {
			System.out.print(array[j]);
		}
	}

	public static int removeDuplicates(int[] nums) {

		if (nums.length <= 0) {
			return 0;
		}

		int i = 0;
		int j = 0;  //双指针，i为快指针（比较元素），j为慢指针（插入位置）

		for (; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}

		return j + 1;
	}
}
