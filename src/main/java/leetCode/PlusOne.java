package leetCode;

import java.util.ArrayList;

/**
 * Date: 2019/6/10 09 :27
 *
 * @author moubin.mo
 */

public class PlusOne {

	public static void main(String[] args) {
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(6);
		integers.add(8);
		integers.add(3);
		integers.add(5);
		integers.add(9);
//        int[] nums = integers.stream().mapToInt(Integer::intValue).toArray();

		int[] nums = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
		int[] result = plusOneV2(nums);
		System.out.println("result=" + result.toString());
	}

	//首先我考虑到了进位和非进位两种情况，然后最高位也出现进位呢？
	//其次，是递归
	//其实，没有那么难，数组转字符串，转int，运算加1，再转数组
	//事实上，越界是存在的，因为数组的长度是无限的,fail;看来，归根结底，都是要字符运算。
	public static int[] plusOne(int[] digits) {
		// 1.数组转string
		StringBuilder numString = new StringBuilder();
		for (int i : digits) {
			numString.append(i);
		}

		// 2.string转int并加1
		Long num = Long.valueOf(numString.toString()) + 1;

		// 3.逐个拆解字符，并转数组
		char[] numChars = num.toString().toCharArray();
		int[] result = new int[numChars.length];
		for (int i = 0; i < numChars.length; i++) {
			result[i] = Integer.parseInt(String.valueOf(numChars[i]));
		}
		return result;
	}

	public static int[] plusOneV2(int[] digits) {
		int length = digits.length;
		int index = length - 1;
		int[] result = new int[digits.length + 1];
		result = plueOneForArray(digits, index);
		return result;
	}

	public static int[] plueOneForArray(int[] array, int index) {
		int[] result = array;
		if (array[index] + 1 < 10) {
			// 1、普通加一，无需进位
			array[index] = array[index] + 1;
		} else {
			// 2、普通加一，需要进位
			array[index] = 0;
			if (index > 0) {
				result = plueOneForArray(array, index - 1);
			} else {
				// 3、进位超出原来长度，重新申请空间
				result = new int[array.length + 1];
				result[0] = 1;
				for (int i = 1; i < result.length; i++) {
					result[i] = array[i - 1];
				}
			}
		}
		return result;
	}

}
