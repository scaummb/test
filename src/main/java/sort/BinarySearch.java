package sort;

/**
 * @author moubin.mo
 * @date: 2020/10/16 15:40
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] array= new int[]{3, 12, 24, 31, 46, 48, 52, 66, 69, 79, 82};
		int index = binarySearch(array, 0, array.length-1, 79);
		System.out.println("findout target index = " + index);
	}
	/**
	 * 二分查找算法（返回该值第一次出现的位置）
	 * @param nums      查询数组
	 * @param start     开始下标
	 * @param end       结束下标
	 * @param findValue 要查找的值
	 * @return int
	 */
	private static int binarySearch(int[] nums, int start, int end, int findValue) {
		if (start <= end) {
			// 中间位置
			int middle = (start + end) / 2;
			// 中间的值
			int middleValue = nums[middle];
			System.out.println("middle="+middle);
			if (findValue == middleValue) {
				// 等于中值直接返回
				return middle;
			} else if (findValue < middleValue) {
				// 小于中值，在中值之前的数据中查找
				return binarySearch(nums, start, middle - 1, findValue);
			} else {
				// 大于中值，在中值之后的数据中查找
				return binarySearch(nums, middle + 1, end, findValue);
			}
		}
		return -1;
	}

	/**
	 * <p>二分查找</p>
	 * @param array 待查找数据
	 * @param aim 目标数值
	 */
	private static void biarySearchV2(int[] array, int aim) {
		int min = 0;
		int max = array.length-1;
		int mid = (min + max)/2;
		while (max > min){
			if (array[mid] == aim){
				System.out.println("findout target = " + mid);
				break;
			}
			if (mid == max || mid == min){
				if (array[min] == aim){
					System.out.println("findout target = " + min);
				}
				if (array[max] == aim){
					System.out.println("findout target = " + max);
				}
				break;
			}
			if (array[mid] > aim){
				max = mid;
			} else if (array[mid] < aim){
				min = mid;
			}
			mid = (min + max)/2;
		}

	}
}
