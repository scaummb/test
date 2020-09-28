package sort;

import java.util.Arrays;

/**
 * @author moubin.mo
 * @date: 2020/9/28 22:24
 */

public class HeapSort {
	public static void main(String[] args) {
		int i = 0;
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		int len = a.length;
		myMinHeapSort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void myMinHeapSort(int[] array){
		int i;
		int len = array.length;
		for (i = len/2-1; i>=0; i--){
			adjustMinHeap(array, i, len-1);
		}
		for (i = len -1; i>=0; i--){
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			adjustMinHeap(array, 0, i-1);
		}
	}

	private static void adjustMinHeap(int[] array, int pos, int len) {
		int temp = 0;
		int child = 0;
		for (temp = array[pos]; 2 * pos + 1 <= len; pos = child){
			child = 2 * pos + 1;
			if (child < len && array[child] <= array[child+1]){
				child++;
			}
			if (array[child] < temp){
				array[pos] = array[child];
			} else {
				break;
			}
		}
		array[pos] = temp;
	}


}
