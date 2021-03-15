package keygenerator.otp;

import org.mortbay.util.UrlEncoded;

/**
 * @author moubin.mo
 * @date: 2020/10/20 18:24
 */

public class TestUrlEncoder {
	private final static UrlEncoded encoder = new UrlEncoded();

	public static void main(String[] args) {
		testUrlEnCode();
	}

	private final static void testUrlEnCode() {
		String string = "51";
		String encode = encoder.encode(string);
		System.out.println(encode);
	}
}
