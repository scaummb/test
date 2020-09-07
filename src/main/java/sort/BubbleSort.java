package sort;

/**
 * @author moubin.mo
 * @date: 2020/9/6 12:50
 */

public class BubbleSort {

	public static void main(String[] args) {
		sort();
	}

	public static void sort(){
		int[] arr = {88,66,999,45,22,1,35,68,88,44,11,99,85,253,44,56};
		int temp = 0;
		for(int i=0; i<arr.length; i++){
			for(int j = 1; j<arr.length -i; j++){
				if (arr[j-1]>arr[j]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int a=0; a<arr.length; a++){
			System.out.println("序列的第"+a+"元素是："+arr[a]);
		}
	}

}
