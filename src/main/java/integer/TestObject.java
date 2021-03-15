package integer;

/**
 * @author moubin.mo
 * @date: 2019/9/18 12:15
 */

public class TestObject {
	public static void main(String[] args) {
		MessageLocator locator = new MessageLocator("key");
		Long anchor = locator.getAnchor();
		locator.setAnchor(12L);
		System.out.println("locator = " + locator);
		System.out.println("anchor = " + anchor);
	}
}
