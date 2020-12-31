package keygenerator.otp;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/8/31 00:06
 */

public class TestBase64 {
	final static BASE64Encoder encoder = new BASE64Encoder();
	final static BASE64Decoder decoder = new BASE64Decoder();
	public static void main(String[] args) throws IOException {
		testDecode();
	}

	private static void testDecode() throws IOException {
		String test = "123345";
		byte[] bytes = decoder.decodeBuffer(test);
		System.out.println(new String(bytes));
	}

	private static void testUrlEncode() {
		String url = "http://210.74.227.63:8801/persons/getPersonInfoLink?systemId=1&qrType=1";
		try {
			String router = "zl://browser/i?";
			router = router + "clientHandlerType=1" + "&url=" + URLEncoder.encode(url, "utf-8");
			System.out.println(router);
		} catch (UnsupportedEncodingException e) {

		}


	}

	/**
	 * <p>Base64重复编码结果</p>
	 */
	private static void testBase64EnCodeDouble() throws IOException {
		String string = "51";
		byte[] bytes1 = decoder.decodeBuffer(string);

		String string2 = "51";
		byte[] bytes2 = decoder.decodeBuffer(string2);


		String string3 = "5151";
		byte[] bytes3 = decoder.decodeBuffer(string3);

		System.out.println(Arrays.asList(bytes1));
		System.out.println(Arrays.asList(bytes2));
		System.out.println(Arrays.asList(bytes3));
		System.out.println(Arrays.asList(bytes3));
	}

	private static void testBase64EnCode2() {
		byte[] bytes = new byte[]{-4,18,1,1, 0,0,0,0, 0,0,3,-24, 95,62,-79,-18, -33,-3,-62,7};
		String encode = encoder.encode(bytes);
		System.out.println(encode);
	}

	private static void testDeCodeSmartQrCode() {
		String encodeCode = "/BIBAQAAAAAAAAPoXz6x7t/9wgc=";
		try {
			byte[] bytes = decoder.decodeBuffer(encodeCode);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private static void testDoorDecode() throws IOException {
		String qrCodeKey = "AQGAvTXy4K4HlLNdD//GbR4hWNvLQ2h5wZzXk8ZGMS9Et5kzPyl7KwSr69lf35h8Yawcp0KI8L7dMiKvOFtL+EktGlEKkblv6IN8qIhCvI2gYjctooIiyGCcm7BuET93GElPEK2rJsQkMGm4E2q/DTk/mVNQvXrYFYwrdOC7RpN95GA/=";
		byte[] bytes = decoder.decodeBuffer(qrCodeKey);
		String value = new String(bytes);
		System.out.println(value);
	}

	private final static void testBase64EnCode(){
		String string = "51";
		String encode = encoder.encode(string.getBytes());
		System.out.println(encode);
	}

	private final static void test() throws IOException {

		final String text = "字串文字";
		final byte[] textByte = text.getBytes("UTF-8");
		//编码
		final String encodedText = encoder.encode(textByte);
		System.out.println(encodedText);
		//解码
		String decodeText = new String(decoder.decodeBuffer(encodedText), "UTF-8");
		System.out.println(decodeText);
	}

	private final static String Base64Decode(){
		String string = "NTEBETAwMDQ1MzE1MDAwMDExNDk5AocBAYBXtXWZJWCYXTqDZWShpYqbCvt4ySidK8a6aTcbYuwbtDcaqXtbdp5H3Q9HAAZS9cn/qxQxGwBPihHaccUNJ/dcGQDXsKvpI0RW/w9AIS3FDbzJw7MSqQM1VZVEuF2CB87+tHTIHJ3l/bTc2U6ztG9USHBJW4PJDFtjjjUmpdGJMlq0LY8=";
//		String string = "NTEBETUyMzE1NzU1ODQ4NDc0MDY2";
		try {
			byte[] code = decoder.decodeBuffer(string);
			if(code[0] == '5' && code[1] == '1') {
				byte[] newCode = new byte[code.length-2];
				System.arraycopy(code, 2, newCode, 0, code.length-2);
				code = newCode;
				String s = new String(code, "UTF-8");
				System.out.println(code);
				System.out.println(s);
				getSmartCardSegments(code);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void getSmartCardSegments(byte[] code) {
		int i = 0, len, typ;
		Map<Integer, byte[]> segments = new HashMap<Integer, byte[]>();

		while(i+2 < code.length) {
			len = (int)code[i+1];
			typ = (int)code[i];
			if(len < 0 || (i+2+len) > code.length) {
				break;
			}
			i += 2;
			byte[] seg = new byte[len];
			System.arraycopy(code, i, seg, 0, len);
			segments.put(new Integer(typ), seg);
			i += len;
		}
	}
}
