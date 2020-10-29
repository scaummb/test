package charset.urlencode;

import java.io.UnsupportedEncodingException;
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
