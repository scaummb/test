package sort;

import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2020/10/6 21:23
 */

public class MergeSort {
	public static void main(String[] args) {
		int[] arrays = {90,80,70,30,40};
		mergeSort(arrays);
		System.out.println(Arrays.toString(arrays));
	}
	public static void mergeSort(int[] array) {
		if (array == null || array.length == 0)
			return;
		int[] temp = new int[array.length];
		mergeSort(array, 0, array.length - 1, temp);
	}
	// 归并
	private static void mergeSort(int array[], int first, int last, int temp[]) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSort(array, first, mid, temp); // 递归归并左边元素
			mergeSort(array, mid + 1, last, temp); // 递归归并右边元素
			mergeArray(array, first, mid, last, temp); // 再将二个有序数列合并
		}
	}

	/**
	 * 合并两个有序数列
	 * array[first]~array[mid]为第一组
	 * array[mid+1]~array[last]为第二组
	 * temp[]为存放两组比较结果的临时数组
	 */
	private static void mergeArray(int array[], int first, int mid, int last, int temp[]) {
		int i = first, j = mid + 1; // i为第n次分解后第一组的起点, j为第n次分解后第二组的起点
		int m = mid, n = last; // m为第n次分解后第一组的终点, n为第n次分解后第二组的终点
		int k = 0; // k用于指向temp数组当前放到哪个位置
		// 比较合并：将两个有序序列循环比较, 填入数组temp
		while (i <= m && j <= n) {
			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			}
			else
				temp[k++] = array[j++];
		}
		// 如果比较完毕, 第一组还有数剩下, 则全部填入temp
		while (i <= m) {
			temp[k++] = array[i++];
		}
		// 如果比较完毕, 第二组还有数剩下, 则全部填入temp
		while (j <= n) {
			temp[k++] = array[j++];
		}
		// 将排好序的数填回到array数组的对应位置
		for (i = 0; i < k; i++) {
			array[first + i] = temp[i];
		}
	}
}
