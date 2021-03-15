package leetCode;

/**
 * Date: 2019/6/17 17 :36
 *
 * @author moubin.mo
 */

public class MySqrt {
	public static void main(String[] args) {
		int x = 2147395599;
		int result = mySqrt(x);
		System.out.println("result=" + result);
	}

	public static int mySqrt(int x) {
		if (x == 1) {
			return 1;
		}

		int result = 1;
		int init = x / 2;
		int max = x;
		while (Math.pow(init, 2) > x) {
			max = init;
			init = init / 2;
		}
		for (int i = init; i <= max; i++) {
			result = i;
			if (Math.pow(i, 2) <= x && Math.pow(i + 1, 2) > x) {
				break;
			}
		}
		return result;
	}

	public static int mySqrtV2(int x) {
		return x = (int) Math.sqrt(x);
	} //溜了，溜了

	public static int mySqrtV3(int x) {
		long left = 0;
		long right = x / 2 + 1;

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long result = mid * mid;
			if (result == (long) x) {
				return (int) mid;
			} else if (result > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) right;
	}

	public static int mySqrtV4(int x) {
		if (x <= 1) {
			return x;
		}
		int l = 1;
		int r = x / 2;
		while (true) {
			int m = l + (r - l) / 2;
			if (m > x / m) {
				r = m - 1;
			} else if (m + 1 > x / (m + 1)) {
				return m;
			} else {
				l = m + 1;
			}
		}
	}
}
