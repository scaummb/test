package url.urlbuild;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
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
	public final static String APP_KEY = "6d00f9de-06c4-417d-9c5f-923dcb52ae09";
	public final static String SECRET_KEY = "ra9VSteycacFGmbRrB/w3waO/AnTX4svgYNHNOF1l6EYnFN5JQp2HY11JknirgYJWLF6pI8L+VC+zECIX6Xftg==";

	/**
	 * <p>
	 * 计算签名
	 *
	 * @param params
	 * @param secretKey </p>
	 */
	public static String computeSignature(Map<String, String> params, String secretKey) {
		assert (params != null);
		assert (secretKey != null);
		try {
			Mac mac = Mac.getInstance("HmacSHA1");
			byte[] rawKey = Base64.decodeBase64(secretKey);

			SecretKeySpec keySpec = new SecretKeySpec(rawKey, "HmacSHA1");
			mac.init(keySpec);

			List<String> keyList = new ArrayList<String>();
			CollectionUtils.addAll(keyList, params.keySet().iterator());
			Collections.sort(keyList);
			//排序结果：
			for (String key : keyList) {
				mac.update(key.getBytes("UTF-8"));
				String val = params.get(key);
				if (val != null && !val.isEmpty()) {
					mac.update(val.getBytes("UTF-8"));
					System.out.println("mac : key = " + key + " , val = " + val);
				}

			}

			byte[] encryptedBytes = mac.doFinal();
			String signature = Base64.encodeBase64String(encryptedBytes);
			return signature;
		} catch (InvalidKeyException e) {
			throw new InvalidParameterException("Invalid secretKey for signing");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("NoSuchAlgorithmException for HmacSHA1", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException for UTF-8", e);
		}
	}

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		hashMap.put("messageCategoryId", "2");
		hashMap.put("appKey", "6d00f9de-06c4-417d-9c5f-923dcb52ae09");
		hashMap.put("nonce", "9");
		hashMap.put("phone", "15622730245");
		hashMap.put("contentType", "TEXT");
		hashMap.put("content", "sample string 2");
		hashMap.put("timestamp", "1607767421178");
		hashMap.put("namespaceId", "11");
		String signature = computeSignature(hashMap, SECRET_KEY);
		System.out.println("signature = " + signature);
	}
}
