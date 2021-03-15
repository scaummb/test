package Utils.demo;

/**
 * Date: 2019/6/30 15 :05
 *
 * @author moubin.mo
 */

public class testMessageStore {
	public static void main(String[] args) {
		String key = "12345678999";
		int hash;
		try {
			String keyString = key.toString();
			if (keyString.matches("^(-[1-9]|[1-9])\\d*")) {
				hash = Integer.parseInt(keyString);
			} else {
				hash = key.hashCode();
			}
		} catch (NumberFormatException var4) {
			hash = key.hashCode();
		}
	}
}
