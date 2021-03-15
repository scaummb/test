package algorithm.numberCarry;

/**
 * @author moubin.mo
 * @date: 2020/9/14 09:08
 */

public class TestNumberCarry {
	private final static Integer MAX_LIMIT = 1000000;
	private static final char[] ALPHA_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public static void main(String[] args) {
		Integer id = 1000001;
		String no = generateNo(id);
		System.out.println(no);
	}

	private static void test() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(ALPHA_ARRAY[25]);
		stringBuffer.insert(0, 'A');
		System.out.println(stringBuffer.toString());
	}

	private static String generateNo(Integer id) {
		StringBuffer stringBuffer = new StringBuffer();
		// 26 * 1000000 进位
		if (id / (ALPHA_ARRAY.length * MAX_LIMIT) > 0) {
			for (int i = 0; i < id / (ALPHA_ARRAY.length * MAX_LIMIT); i++) {
				stringBuffer.append(ALPHA_ARRAY[25]);
			}
			// 取余
			id = id % (ALPHA_ARRAY.length * MAX_LIMIT);
		}

		// 1000000 进位
		if (id / MAX_LIMIT > 0) {
			stringBuffer.insert(0, ALPHA_ARRAY[id / MAX_LIMIT - 1]);
			id = id % MAX_LIMIT;
		}

		// id
		stringBuffer.append(id.toString());
		return stringBuffer.toString();
	}
}
