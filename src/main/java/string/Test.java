package string;

import java.util.Date;
import java.util.Random;

/**
 * @author moubin.mo
 * @date: 2019/8/15 18:33
 */

public class Test {
	public static void main(String[] args) {
		testRandom();
	}

	private static void testString() {
		String pushEventValue = String.format("%d:%s:%d:%d:%s:%d", 550809, "beb651362f134e9ab7599f41d9692585", 203000, 11, "USER", 11);
		System.out.println(pushEventValue);
		String stringValue = String.format("Today is %tc, i am %s", new Date(), "mmb");
		System.out.println(stringValue);
	}

	private static final void testRandom() {
		String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z"
		};

		for (int x = 0; x < 100; x++) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int y = 0; y < 15; y++) {
				int i = new Random().nextInt(61);
				stringBuffer.append(chars[i]);
			}
			System.out.println("'" + stringBuffer.toString() + "',");
		}
	}
}
