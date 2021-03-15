package algorithm.numberCarry;

import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2021/2/24 20:28
 */

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {6, 5, 4, 3, 2};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	//分治法，拆分到最小，空间复杂度O(n)
	private static void mergeSort(int[] a) {
		int[] temp = new int[a.length];
		mergeSort(a, 0, a.length - 1, temp);
	}

	private static void mergeSort(int[] a, int begin, int end, int[] temp) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(a, begin, mid, temp);
			mergeSort(a, mid + 1, end, temp);
			merge(a, begin, mid, end, temp);
		}
	}

	private static void merge(int[] a, int begin, int mid, int end, int[] temp) {
		int i = begin, j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (a[i] < a[j]) {
				//左边小，继续比较左边（左指针左移）
				temp[k++] = a[i++];
			} else {
				//右边小，继续比较右边（右指针右移）
				temp[k++] = a[j++];
			}
		}

		//剩下左边边数组,依次保存进去
		while (i <= mid) {
			temp[k++] = a[i++];
		}

		//剩下右边数组,依次保存进去
		while (j <= end) {
			temp[k++] = a[j++];
		}

		//temp，以begin为基准，填充一段数据
		for (int b = 0; b < k; b++) {
			a[b + begin] = temp[b];
		}

	}

}
