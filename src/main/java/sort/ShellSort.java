package sort;

/**
 * <p>
 *     希尔排序算法
 *     希尔排序是1959年，Shell发明的，这是第一个突破O(n2)的排序算法，他与直接插入排序不同的是，他会优先比较距离较近的元素。因此，希尔排序又叫做缩小增量排序。当步长为1时，算法变为插入排序，这就保证了数据一定会被排序。
 *     希尔排序的关键，并非随便的分组然后各自排序，而是将相隔某个“增量”的记录组成一个子序列，实现跳跃式移动，使得排序效率提高。
 * </p>
 * @author moubin.mo
 * @date: 2020/9/6 22:04
 */

public class ShellSort {
	public static void main(String[] args)
	{
		int i = 0;
		int a[] = {6, 5, 3, 1, 8, 7, 2, 4, 9, 0};
		int len = a.length;
		shellSort(a);
	}

	private static void shellSort(int arr[]){
		int length = arr.length;
		int i,j;
		int h;
		int temp;
		// 确定步长h
		for (h = length/2; h > 0; h = h/2){
			// 遍历子序列，每次下标增量为h
			for (i = h; i < length; i ++){
				temp = arr[i];
				// 子序列插入比较
				for (j = i-h; j >= 0; j -= h){
					if (temp < arr[j]){
						arr[j + h] = arr[j];
					} else {
						break;
					}
				}
				arr[j+h] = temp;
			}
		}

		for (int a=0; a<arr.length; a++){
			System.out.println("序列的第"+a+"元素是："+arr[a]);
		}
	}
}
