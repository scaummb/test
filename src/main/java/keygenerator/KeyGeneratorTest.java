package keygenerator;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author moubin.mo
 * @date: 2021/2/24 11:12
 */

public class KeyGeneratorTest {
	private final static String ALGORITHM = "HmacSHA1";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
		keyGenerator.init(512);
		Key secretKey = keyGenerator.generateKey();
		String resultStr = org.apache.commons.codec.binary.Base64.encodeBase64String(secretKey.getEncoded());
	}
}
