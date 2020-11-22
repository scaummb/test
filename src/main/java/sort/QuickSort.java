package sort;

import java.util.Arrays;

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
		QSort(array, 0, 5);
		System.out.println(Arrays.toString(array));
	}

	private static void QSort(int[] nums, int low, int high){
		int pivot;
		if (low >= high){
			return;
		}
		// 难点也是核心，partition函数工作内容：选取某个中枢元素（枢轴,pivot），然后想办法将它放到某一位置，
		// 使得它左边的值都小于它，右边的值都大于它。
		pivot = partition(nums, low, high);
		//分解为更小的问题，递归
		QSort(nums, low, pivot -1);
		QSort(nums, pivot+1, high);
	}

	/**
	 * <p>
	 *     1、交换顺序表nums的记录，使得枢轴到位，并返回所在位置
	 *     2、确保枢轴左边元素<枢轴，枢轴右边元素>枢轴
	 *     3、选取枢轴策略就是元素的中位数的下标。
	 */
	private static int partition(int[] nums, int low, int high) {
		int pivotKey = nums[low];
		while (low < high){
			while (low < high && nums[high] >= pivotKey){
				//find out the element which is smaller then pivotKey
				high --;
			}
			//一次遍历，找到比基准值更小的元素并排序到最前面
			swap(nums, low, high);
			while (low < high && nums[low] <= pivotKey){
				//find out the element which is bigger then pivotKey
				low++;
			}
			//一次遍历，找到比基准值更大的元素并排序到最houmian1
			swap(nums, low, high);
		}
		return low;
	}

	static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
