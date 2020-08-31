package keygenerator.otp;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author moubin.mo
 * @date: 2020/8/31 00:06
 */

public class TestBase64 {
	public static void main(String[] args) throws IOException {

		final BASE64Encoder encoder = new BASE64Encoder();
		final BASE64Decoder decoder = new BASE64Decoder();
		final String text = "字串文字";
		final byte[] textByte = text.getBytes("UTF-8");
		//编码
		final String encodedText = encoder.encode(textByte);
		System.out.println(encodedText);
		//解码
		String decodeText = new String(decoder.decodeBuffer(encodedText), "UTF-8");
		System.out.println(decodeText);

	}
}
