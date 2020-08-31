package keygenerator.otp;

import java.io.UnsupportedEncodingException;

/**
 * @author moubin.mo
 * @date: 2020/8/31 00:16
 */

public class TestStringToByteArrays {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a="田江南你好";
		byte[] by = null;
		by = a.getBytes("utf-8");
		System.out.println(by);
	}
}
