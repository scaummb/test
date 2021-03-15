package sort;

/**
 * <p>
 * 希尔排序算法
 * 希尔排序是1959年，Shell发明的，这是第一个突破O(n2)的排序算法，他与直接插入排序不同的是，他会优先比较距离较近的元素。因此，希尔排序又叫做缩小增量排序。当步长为1时，算法变为插入排序，这就保证了数据一定会被排序。
 * 希尔排序的关键，并非随便的分组然后各自排序，而是将相隔某个“增量”的记录组成一个子序列，实现跳跃式移动，使得排序效率提高。
 * </p>
 */

public class ShellSort {
	public static void main(String[] args) {
		int i = 0;
		int a[] = {6, 5, 3, 1, 8, 7, 2, 4, 9, 0};
		int len = a.length;
		shellSort(a);
	}

	private static void shellSort(int arr[]) {
		int length = arr.length;
		int i, j;
		int h;
		int temp;
		// 确定步长h(确定步长序列以及需要几趟完成希尔排序)
		for (h = length / 2; h > 0; h = h / 2) {
			// 遍历子序列，每次下标增量为h
			for (i = h; i < length; i++) {
				temp = arr[i]; //待插入元素
				// 子序列插入比较。可能会有疑问，为什么不是按照图示的[32,26,60]来逐个比较呢？因为代码不需要像图示那样，额外花销来维护第几趟。
				// 当i自增到60的下标时，下面的for循环，相当于会插入比较到[26,32]的子序列里面了。这是非常秒的！
				for (j = i - h; j >= 0; j -= h) {
					if (temp < arr[j]) {
						//较大值往后挪
						arr[j + h] = arr[j];
					} else {
						break;
					}
				}
				// 此时的j<0，因此temp赋值的意思是，将原本较小值移动到前面
				arr[j + h] = temp;
			}
		}

		for (int a = 0; a < arr.length; a++) {
			System.out.println("序列的第" + a + "元素是：" + arr[a]);
		}
	}
}
