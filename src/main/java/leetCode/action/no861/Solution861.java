package leetCode.action.no861;

/**
 * <p>
 * 贪心算法：尽可能多，尽可能位1
 * 反复观看，发现保证每行首位为1时，为每行最大值；从第二列开始每列的1个数大于等于0的个数时，为矩阵总值最大！
 * 1.将首位不为0的行进行翻转操作
 * 2.统计每列中0的个数，将总的0个数多余1个数的列进行翻转
 * 3.计算二进制值得出结果。
 * </p>
 * <p>
 * 执行用时：
 * 1 ms , 在所有 Java 提交中击败了 28.80% 的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了 75.00% 的用户
 *
 * @author moubin.mo
 * @date: 2020/12/7 22:31
 */

public class Solution861 {
	public static void main(String[] args) {
		int[][] a = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
		int i = matrixScore(a);
		System.out.println(i);
	}

	public static int matrixScore(int[][] A) {
		if (A.length <= 0) {
			return 0;
		}

		//行反转
		for (int row = 0; row < A.length; row++) {
			if (A[row][0] == 0) {
				reverseRow(A[row]);
			}
		}

		// 列反转
		for (int column = 0; column < A[0].length; column++) {
			int zeroCount = 0;
			int oneCount = 0;
			// 遍历每一列
			for (int index = 0; index < A.length; index++) {
				if (A[index][column] == 1) {
					oneCount++;
				} else if (A[index][column] == 0) {
					zeroCount++;
				}
			}
			// 0的数量大于1的数量，该列反转
			if (zeroCount > oneCount) {
				reverseColumn(A, column);
			}
		}

		return getSum(A);
	}

	//反转某行
	private static int[] reverseRow(int[] array) {
		for (int raw = 0; raw < array.length; raw++) {
			if (array[raw] == 0) {
				array[raw] = 1;
			} else if (array[raw] == 1) {
				array[raw] = 0;
			}
		}
		return array;
	}

	//反转某列
	private static int[][] reverseColumn(int[][] array, int columnNo) {
		for (int rawNo = 0; rawNo < array.length; rawNo++) {
			if (array[rawNo][columnNo] == 0) {
				array[rawNo][columnNo] = 1;
			} else if (array[rawNo][columnNo] == 1) {
				array[rawNo][columnNo] = 0;
			}
		}
		return array;
	}

	// 计算二维数组总数
	private static int getSum(int[][] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			// 计算每一行的值
			sum += (int) getSum(a[i]);
		}
		return sum;
	}

	private static long getSum(int[] tmp) {
		int sum = 0;
		for (int raw = 0; raw < tmp.length; raw++) {
			if (tmp[raw] == 1) {
				//左移raw位
				sum += (1 << (tmp.length - raw - 1));
			}
		}
		return sum;
	}

}