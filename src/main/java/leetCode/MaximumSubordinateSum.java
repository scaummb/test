package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/6/8 10 :39
 *
 * @author moubin.mo
 */

public class MaximumSubordinateSum {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(-2);
		list.add(1);
		list.add(-3);
		list.add(4);
		list.add(-1);
		list.add(2);
		list.add(1);
		list.add(-5);
		list.add(4);
		int[] array = list.stream().mapToInt(Integer::intValue).toArray();
//        int sum = maxSubArray(array);
//        int sum = maxSubArrayV2(array);
		int sum = maxSubArrayPart(array, 0, array.length - 1);
		System.out.println("max = " + sum);
	}


	public static int maxSubArray(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		}
		Integer max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			if (temp > max) {
				max = temp;
			}
			for (int j = i + 1; j < nums.length; j++) {
				temp += nums[j];
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}

	/**
	 * 主要是利用逐步求解，以连续数组结束位置为每一步的解，
	 * sum其实就是记录了上一步骤的解，在这一步骤进行对比，如果上一步骤的解<0则舍弃。
	 * 最终得到这一步骤解，与之前步骤解的最大值res进行比较，保存当前的最优解。
	 */
	public static int maxSubArrayV2(int[] nums) {
		int sum = 0;
		int res = nums[0];
		// 1.一次遍历解决
		for (int num : nums) {
			// 2.上次结果是否正数 ? 与新元素相加 : 取新元素
			sum = sum > 0 ? (sum + num) : num;
			// 3.该次结果与上次结果比较与赋值
			if (res < sum) {
				res = sum;
			}
		}
		return res;
	}


	//-------------------分治法----------------------

	/**
	 * 通过递归分治不断的缩小规模，问题结果就有三种，左边的解，右边的解，以及中间的解（有位置要求，从中介mid向两边延伸寻求最优解），
	 * 得到三个解通过比较大小，等到最优解。
	 */
	private static int maxSubArrayPart(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		return Math.max(
				maxSubArrayPart(nums, left, mid),
				Math.max(
						maxSubArrayPart(nums, mid + 1, right),
						maxSubArrayAll(nums, left, mid, right)
				)
		);
	}

	//左右两边合起来求解
	private static int maxSubArrayAll(int[] nums, int left, int mid, int right) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= left; i--) {
			sum += nums[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}

}
