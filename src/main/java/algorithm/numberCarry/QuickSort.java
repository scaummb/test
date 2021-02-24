package algorithm.numberCarry;

import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2021/2/24 20:27
 */

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {6,5,4,3,2};
		quicksort(a, 0, 4);
		System.out.println(Arrays.toString(a));
	}

	//选出基准，左边小，右边大，双指针法(碰撞则停止，分割)
	private static void quicksort(int[] a, int begin, int end){
		//过滤
		if (begin >= end){
			return;
		}
		int pivote = position(begin, end, a);
		quicksort(a, begin, pivote-1);
		quicksort(a, pivote+1, end);
	}

	private static int position(int begin, int end, int[] a) {
		int pivotKey = a[begin];
		while (begin < end){
			//直至找到比pivote小的数据。先右指针移动
			while (begin < end && ((a[end] >= pivotKey))){
				end--;
			}
			swap(a, begin, end);
			//直至找到比pivote大的数据。在坐指针移动
			while (begin < end && ((a[begin] <= pivotKey))){
				begin++;
			}
			swap(a, begin, end);
		}
		return begin;
	}

	static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
