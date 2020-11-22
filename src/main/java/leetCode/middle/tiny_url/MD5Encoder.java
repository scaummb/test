package leetCode.middle.tiny_url;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hash算法加密：MD5
 * @author moubin.mo
 * @date: 2019/9/14 16:01
 */

public class MD5Encoder {

	public static void main(String[] args){
		try {
			String encodingString = md5("TestStrategy", "key");
			boolean verifyResult = verify("TestStrategy", "key", encodingString);
			System.out.println("encodingString = " + encodingString + ", verifyResult = " + verifyResult);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * MD5方法
	 *
	 * @param text 明文
	 * @param key 密钥
	 * @return 密文
	 * @throws Exception
	 */
	public static String md5(String text, String key) throws Exception {
		//加密后的字符串
		String encodeStr=DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
		return encodeStr;
	}

	/**
	 * MD5验证方法
	 *
	 * @param text 明文
	 * @param key 密钥
	 * @param md5 密文
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		//根据传入的密钥进行验证
		String md5Text = md5(text, key);
		if(md5Text.equalsIgnoreCase(md5))
		{
			System.out.println("MD5验证通过");
			return true;
		}

		return false;
	}
}
