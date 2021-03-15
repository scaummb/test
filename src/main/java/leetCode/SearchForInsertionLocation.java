package leetCode;

/**
 * Date: 2019/5/20 21 :37
 *
 * @author moubin.mo
 */

public class SearchForInsertionLocation {
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int target = 0;
		int result = searchInsertV2(nums, target);
		System.out.println("result=" + result);
	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		// 1.设置比较次数
		int count = 0;
		for (int index = 0; index < nums.length; index++) {
			// 2.元素与目标相等，或元素比目标大
			if (nums[index] == target || nums[index] > target) {
				return index;
			} else if (nums[index] < target) {
				// 3.比较次数加一
				count++;
			}
		}
		return count;
	}

	// 遍历数组
	public static int searchInsertV2(int[] nums, int target) {
		int len = nums.length;
		if (len == 0) {
			return 0;    // if the nums is empty, return 0
		}
		for (int i = 0; i < len; i++) {
			if (target <= nums[i]) {  //  when target <= nums[i] , return
				return i;
			}
		}
		return len;
	}

	// 二分查找
	public static int searchInsertV3(int[] nums, int target) {
		// 1.设置左右边界值
		int left = 0;
		int right = nums.length;

		while (left < right) {
			// 2.取中间值mid = left + 差距一半
			int mid = left + (right - left) / 2;

			// 3.比较两值，根据结果设置左右边界
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
