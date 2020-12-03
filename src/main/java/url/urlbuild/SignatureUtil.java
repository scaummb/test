package url.urlbuild;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author moubin.mo
 * @date: 2020/10/16 09:42
 */

public class SignatureUtil {

	final static BASE64Decoder decoder = new BASE64Decoder();
	final static BASE64Encoder encoder = new BASE64Encoder();

	public final static String APP_KEY = "49ba4da8-75b0-4f0a-83b3-e9574c9ae8c6";
	public final static String SECRET_KEY = "KwVMyXiuq3G0bfP8jJTVTxlXF9PWaUEUwAj6orJy++Lc1DE42CLfIV8Dof3Soz4jG0bqOzzAG0/6tZF7D6uhxw==";

	private final static Logger LOGGER = LoggerFactory.getLogger(SignatureUtil.class);

	/**
	 * <p>
	 *     计算签名
	 * @param params
	 * @param secretKey
	 * </p>
	 */
	public static String computeSignature(Map<String, String> params, String secretKey) {
		assert(params != null);
		assert(secretKey != null);
		try {
			Mac mac = Mac.getInstance("HmacSHA1");
			byte[] rawKey = Base64.decodeBase64(secretKey);

			SecretKeySpec keySpec = new SecretKeySpec(rawKey, "HmacSHA1");
			mac.init(keySpec);

			List<String> keyList = new ArrayList<String>();
			CollectionUtils.addAll(keyList, params.keySet().iterator());
			Collections.sort(keyList);
			for(String key : keyList) {
				mac.update(key.getBytes("UTF-8"));
				String val = params.get(key);
				if(val != null && !val.isEmpty()){
					mac.update(val.getBytes("UTF-8"));
					System.out.println("mac : key = " + key + " , val = " + val);
				}

			}

			byte[] encryptedBytes = mac.doFinal();
			String signature = Base64.encodeBase64String(encryptedBytes);

			return signature;
		} catch(InvalidKeyException e) {
			throw new InvalidParameterException("Invalid secretKey for signing");
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("NoSuchAlgorithmException for HmacSHA1", e);
		} catch(UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException for UTF-8", e);
		}
	}

	/**
	 * <p>
	 *     校验签名
	 * @param params
	 * @param secretKey
	 * @param signatureToVerify
	 * </p>
	 */
	public static boolean verifySignature(Map<String, String> params, String secretKey, String signatureToVerify) {
		String signature = computeSignature(params, secretKey);
		if(signature.equals(signatureToVerify))
			return true;
		return false;
	}

	/**
	 * <p>Base64解码</p>
	 * @param cardCode
	 * @return byte[]
	 */
	public static byte[] decodeBase64StringToBytes(String cardCode) {
		try {
			return decoder.decodeBuffer(cardCode);
		} catch (IOException e) {
			LOGGER.error("SignatureUtil decodeBase64StringToBytes error, {}", e);
		}
		return new byte[1];
	}

	/**
	 * <p>Base64编码</p>
	 * @param segment
	 * @return String
	 */
	public static String encodeBase64BytesToString(byte[] segment) {
		return encoder.encode(segment);
	}

	public static void main(String[] args) {
		/**
		 我这边计算过程是：
		 1、userId=550500
		 2、appKey=49ba4da8-75b0-4f0a-83b3-e9574c9ae8c6
		 3、timestamp=1606471402610
		 4、nonce=1529934482
		 5、secreatKey=KwVMyXiuq3G0bfP8jJTVTxlXF9PWaUEUwAj6orJy++Lc1DE42CLfIV8Dof3Soz4jG0bqOzzAG0/6tZF7D6uhxw==
		 6、计算signature=5Vkt+GWluyl49zMTnYmyDaLfPFA=
		 * */
		HashMap hashMap = new HashMap();
		hashMap.put("userId", "550921");
		hashMap.put("appKey", "49ba4da8-75b0-4f0a-83b3-e9574c9ae8c6");
		hashMap.put("timestamp", "1606477957028");
		hashMap.put("nonce", "447473441");
		String signature = computeSignature(hashMap, SECRET_KEY);
		System.out.println(signature);
	}
}
