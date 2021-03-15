package leetCode.middle.tiny_url;

/**
 * @author moubin.mo
 * @date: 2019/9/14 15:30
 */

public class TinyURL {

	private static final char SECRET_KEY = 8;

	public static void main(String[] args) {
		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		String shortUrl1 = encode(longUrl);
		String longUrl1 = decode(shortUrl1);
		System.out.println(longUrl.equals(longUrl1));
	}

	// Encodes a URL to a shortened URL.
	public static String encode(String longUrl) {
		// 将需要加密的内容转换为字节数组
		byte[] bt = longUrl.getBytes();
		for (int i = 0; i < bt.length; i++) {
			// 通过异或运算进行加密
			bt[i] = (byte) (bt[i] ^ (int) SECRET_KEY);
		}
		// 将加密后的字符串保存到 newresult 变量中
		String newresult = new String(bt, 0, bt.length);
		return newresult;
	}

	// Decodes a shortened URL to its original URL.
	public static String decode(String shortUrl) {
		// 将需要加密的内容转换为字节数组
		byte[] bt = shortUrl.getBytes();
		for (int i = 0; i < bt.length; i++) {
			// 通过异或运算进行加密
			bt[i] = (byte) (bt[i] ^ (int) SECRET_KEY);
		}
		// 将加密后的字符串保存到 newresult 变量中
		String newresult = new String(bt, 0, bt.length);
		return newresult;
	}


}
