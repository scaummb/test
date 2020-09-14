package integer.testCount;

/**
 * @author moubin.mo
 * @date: 2020/9/8 14:42
 */

public class TestCountChange {
	public static void main(String[] args) {
		Integer failCount = 10;
		Integer successCount = 0;
		generateUnitQrCode(failCount, successCount);
		System.out.println("failCount = " + failCount.intValue());
		System.out.println("successCount = " + successCount.intValue());
	}

	private static void generateUnitQrCode(Integer failCount, Integer successCount) {
		failCount--;
		successCount--;
	}
}
