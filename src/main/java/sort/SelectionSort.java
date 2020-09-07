package sort;

/**
 * @author moubin.mo
 * @date: 2020/9/6 12:54
 */

public class SelectionSort {
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1,0};
		selectionSort(a);
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int k = i;
			//find out the smallest one.
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[k]) {
					k = j;
				}
			}
			if (k > i) {
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}

		for (int a=0; a<arr.length; a++){
			System.out.println("序列的第"+a+"元素是："+arr[a]);
		}
	}
}