package leetCode.action.test;

/**
 * 一对小兔兔，出生后第3个月起每个月都生一对兔子，等小兔子长到第3个月后每个月又可以生一对兔子，如果兔子都长生不死，请问每个月的兔子总数是多少？
 *
 * 解法：斐波那契数列
 *
 */

public class RabbitCount {


	public static void main(String[] args) {
		int month = 6;
		getSum(month);
	}

	private static void getSum(int month) {
		if (month == 1) {
			System.out.println("第 1 个月：" + 1);
		}
		if (month == 2) {
			System.out.println("第 2 个月：" + 1);
		}

		int f0 = 1, f1 = 1, fm;
		for (int i = 3; i <= month; i++){
			fm = f0 + f1;
			f0 = f1;
			f1 = fm;
			System.out.println("第 " + i + " 个月：" + fm);
		}
	}


}

