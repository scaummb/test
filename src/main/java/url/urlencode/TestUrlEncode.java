package url.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 *     URLENCODE：　　
 *     对于非ASCII字符，需要使用ASCII字符集的超集进行编码得到相应的字节，然后对每个字节执行百分号编码。对于Unicode字符，RFC文档建议使用utf-8对其进行编码得到相应的字节，然后对每个字节执行百分号编码。如"中文"使用UTF-8字符集得到的字节为0xE4 0xB8 0xAD 0xE6 0x96 0x87，经过Url编码之后得到"%E4%B8%AD%E6%96%87"。
 * </p>
 * @author moubin.mo
 * @date: 2020/10/21 12:21
 */

public class TestUrlEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		test3();
	}

	private static void test3() throws UnsupportedEncodingException {
		String enCodedUrl = "zl://browser/i?clientHandlerType=1&url=http%3A%2F%2F116.239.33.45%3A6062%2Fpersons%2FgetPersonInfoLink%3FsystemId%3D1%26qrType%3D1";
		String decodeUrl = URLDecoder.decode(enCodedUrl, "utf-8");
		System.out.println(decodeUrl);
	}

	private static void test2() throws UnsupportedEncodingException {
		String url = "https://m.baidu.com"; //第三方链接
		String encodeUrl = URLEncoder.encode(url, "utf-8");
		String getUrl = "zl://browser/i?"
				+ "url=https://evh/oauth2/authorize?response_type=code&client_id=6d00f9de-06c4-417d-9c5f-923dcb52ae09&redirect_uri="+encodeUrl+"&scope=basic&state=zhiwei#oauth2_redirect"
				+ "#sign_suffix";
	}

	private static void test1() throws UnsupportedEncodingException {
		String text1 = "莫";
		String text2 = "123";
		String text3 = "123=/";
		String encode1 = URLEncoder.encode(text1, "UTF-8");
		String encode2 = URLEncoder.encode(text2, "UTF-8");
		String encode3 = URLEncoder.encode(text3, "UTF-8");
		System.out.println(encode1);
		System.out.println(encode2);
		System.out.println(encode3);
	}
}
