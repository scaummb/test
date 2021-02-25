package keygenerator;

import keygenerator.otp.TimeBasedOneTimePasswordGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author moubin.mo
 * @date: 2019/10/16 08:47
 */
@Slf4j
public class KeyGeneratorUtil {
	private final static Logger LOGGER = LoggerFactory.getLogger(KeyGeneratorUtil.class);
	/**
	 * A string identifier for the HMAC-SHA1 algorithm (required by HOTP and allowed by TOTP). HMAC-SHA1 is the default
	 * algorithm for TOTP.
	 */
	public static final String TOTP_ALGORITHM_HMAC_SHA1 = "HmacSHA1";
	private static long stepInSecond = 30;
	private static String cardKey = "wNmfqGmeE0x5IQmn1OXK7ZFtTC38d7AiHTB4EVHRoM0s7P8gxmhHsR9S4bCGTAQ0WIKjVwSXYNdSiJ6WlBQHog==";

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, ParseException {
//		javax.crypto.KeyGeneratorUtil keyGenerator = null;
//		try {
//			for (int i=1; i<100; i++) {
//				keyGenerator = javax.crypto.KeyGeneratorUtil.getInstance(TOTP_ALGORITHM_HMAC_SHA1);
//				keyGenerator.init(512);
//				Key secretKey = keyGenerator.generateKey();
//				String resultStr = Base64.encodeBase64String(secretKey.getEncoded());
//
//				System.out.println("i = "+i+" resultStr = "+resultStr+" resultStr.length() = "+resultStr.length());
////				System.out.println("i = "+i+" secretKey = "+secretKey+" resultStr = "+resultStr+" resultStr.length() = "+resultStr.length());
//			}
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}

//		String a = "0IgefqMgMBo+DQioO/xpLswHv7rX94Q1yk/QxO7Fm5QPAFF8gIbJrTLfXhUqTRarMExf5659natH36rr1EXvzw==";
//		String b = "t9QsATGmk9N0PcXC1cwJtyVrTJNGCZEQDI2vv81macgsGKlNjswdFi5kZvpg2J0ub6ZrZaQsFac0bezWdhJjTw==";
//		String c = "4FMvMFjJa+9BtKU/Rr8RjvEEqzlloSeHxVIvBTB71ZqtzN4NxJSeCDXPbsLdRt1YgJOjJBPDLvs57UFAL5vj8g==";
//		String d = "rqsUMW69G2tgKmk03HmakRElYW5+K+WG3h47qyCrCQmx+SqbV+kbibG/qLplwX52rWyOtgX/biqBnay6R2MdJA==";
//		System.out.println(a.substring(1));
//		String e = "51109888317299444646";
//		System.out.println(e.length());

//		String payCode = "03493008534870212";
//		long uid = payCodeVerify(payCode);
//		System.out.println("uid = " + uid);

//		Long uid = 34930085L;
//		Long totp = 34870212L;
//		uid = uid ^ totp;
//

//		Long nowInSec = new Date().getTime() / 1000;
//		long time = nowInSec + 1*stepInSecond;
//		byte[] decode = Base64.getDecoder().decode(cardKey.getBytes());
//		System.out.println("decode = " + decode);
//		Date date = new Date();
//		long time = date.getTime();
//		TimeBasedOneTimePasswordGenerator totp = getTotp();
//		int code = generateTotp(totp, cardKey, time/1000);
//		System.out.println("code = " + code);

		String payCode = "07707692776615049";
		String randomUid = payCode.substring(0, 9);
		String frontTotpCode = payCode.substring(9, 17);
		Long uid = Long.parseLong(randomUid);
		Long totpCodeInt = Long.parseLong(frontTotpCode);
		uid = (uid ^ totpCodeInt);

		Date date = new Date();
		long time = date.getTime();
		long timeStamp = time/1000 + 1*stepInSecond;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date1 = df.parse("2019-10-17 15:40:00");
		long time22 = date1.getTime();
		long timeStamp22 = time22/1000 + 1*stepInSecond;

		TimeBasedOneTimePasswordGenerator totp;
		totp = getTotp();
		int code = generateTotp(totp, cardKey, timeStamp);
		if(code == totpCodeInt) {
			System.out.println(" [success] timeStamp = " + timeStamp22 + ", totp = " + totp +", uid = " + uid + ", code = " + code +", frontTotpCode = " + frontTotpCode);
		} else {
			System.out.println(" [fail] timeStamp = " + timeStamp22 + ", totp = " + totp +", uid = " + uid + ", code = " + code +", frontTotpCode = " + frontTotpCode);
		}

		String strCode = String.valueOf(code);
		String prefix = "511";
		Integer userId = 306881;
		int data = code ^ userId;
		String dataStr = String.valueOf(data);
		String verifyCode = prefix + String.valueOf(data) + strCode;
		System.out.println(verifyCode);

//		Long time = new Date().getTime();
//		TimeBasedOneTimePasswordGenerator totp = getTotp();
//		int code = generateTotp(totp, cardKey, time/1000);
//		System.out.println("frontTotpCode = " + frontTotpCode + " uid = " + uid + " code = " + code + " time = " + time/1000 + " cardKey = " + cardKey);
//		int code2 = generateTotp(totp, cardKey, time/1000 + stepInSecond -1);
//		System.out.println("frontTotpCode = " + frontTotpCode + " uid = " + uid + " code2 = " + code2 + " time = " + time/1000 + " cardKey = " + cardKey);

	}

	private static long payCodeVerify(String payCode) throws InvalidKeyException, NoSuchAlgorithmException {
		TimeBasedOneTimePasswordGenerator totp;
		int validWindow = 1;
		long ok = -1;

		totp = getTotp();
		Long nowInSec = System.currentTimeMillis() / 1000;
		String randomUid = payCode.substring(0, 9);
		String totpCode = payCode.substring(9, 17);
		Long uid = Long.parseLong(randomUid);
		Long totpCodeInt = Long.parseLong(totpCode);
		uid = (uid ^ totpCodeInt);

		int code = generateTotp(totp, cardKey, nowInSec + stepInSecond);
		System.out.println("code = " + code);
		if(code == totpCodeInt) {
			ok = uid;
		}
		return ok;
	}


	private static TimeBasedOneTimePasswordGenerator getTotp() throws NoSuchAlgorithmException {
		TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();
		if(totp == null) {
			totp = new TimeBasedOneTimePasswordGenerator(stepInSecond, TimeUnit.SECONDS, 8);
		}
		return totp;
	}

	private static int generateTotp(TimeBasedOneTimePasswordGenerator totp, String smartKey, long nowInSec) throws InvalidKeyException, NoSuchAlgorithmException {
		SecretKeySpec key = new SecretKeySpec(Base64.getDecoder().decode(smartKey.getBytes()), totp.getAlgorithm());

		int code = totp.generateOneTimePassword(key, new Date(nowInSec * 1000));
		return code;
	}


}
