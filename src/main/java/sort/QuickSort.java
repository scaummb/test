package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 *     快速排序算法：分而治之（分治+递归）
 * </p>
 * @author moubin.mo
 * @date: 2020/10/20 23:18
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] array = {2, 1, 7, 9, 5, 8};
		int i = 0;
		int len = array.length;
		sort(array, 0, 5);
		System.out.println(Arrays.toString(array));
	}

	private static void sort(int[] nums, int low, int high){
		int i,j;
		if (low >= high){
			return;
		}
		i = low;
		j = high;

		// 基准值以首位元素开始
		int index = new Random().nextInt(j-i) + i;

		// 难点：子序列有序(单指针/双指针)

		//分解为更小的问题，递归
		sort(nums, low, index -1);
		sort(nums, index, high);
	}

	static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
