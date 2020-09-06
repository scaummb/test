package sort;

/**
 * @author moubin.mo
 * @date: 2020/9/6 13:03
 */

public class StrightInsertion {
	public static void main(String[] args) {
		int[] arr = {12, 15, 13, 46, 55, 1, 5, 3};
		strightinsertion(arr);
	}
	public static void strightinsertion(int [] arr){
		int tmp ;
		for (int i=1; i<arr.length; i++){
			for(int j=i; j>0; j--){
				if (arr[j]<arr[j-1]){
					tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for (int a=0; a<arr.length; a++){
			System.out.println("序列的第"+a+"元素是："+arr[a]);
		}
	}
}
