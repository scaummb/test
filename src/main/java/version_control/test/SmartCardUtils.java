package version_control.test;

import keygenerator.otp.TimeBasedOneTimePasswordGenerator;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author moubin.mo
 * @date: 2020/10/22 10:45
 */

public class SmartCardUtils {
	private static long stepInSecond = 30;
	private static ThreadLocal<TimeBasedOneTimePasswordGenerator> totpLocal = new ThreadLocal<TimeBasedOneTimePasswordGenerator>();
	private static String smartKey = "7WmBKVVKm3g8TSMRJ08Tww/MdUBnA0FsVLAr6SiQEocVWne+qdnMm8GMifRIMD6leIcA2ovS9FVTawykwB6f/A==";
	final static BASE64Decoder decoder = new BASE64Decoder();
	final static BASE64Encoder encoder = new BASE64Encoder();

	public static void main(String[] args) {
		String qrCode = "NTEDBwE3NjU1Nzk=";
		decode(qrCode);

//		TimeBasedOneTimePasswordGenerator totp;
//		totp = getTotp();
//		int code = generateTotp(totp, smartKey, (DateHelper.currentGMTTime().getTime() / 1000) + 1 * stepInSecond);

//		String totp = TOTP.generateTOTP(smartKey, DateHelper.currentGMTTime().getTime(), 30, "8", "HmacSHA1");
//		String qrCode = getQrCode(totp, true);
//		System.out.println(qrCode);
	}

	private static void decode(String qrCode) {
		try {
			if(qrCode == null || qrCode.length() < 18) {
				System.out.println("error");
			}
			System.out.println("normal -> qrCode = " + qrCode);
			byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(qrCode);
			qrCode = new String(bytes);
			System.out.println("Base64.decode -> qrCode = " + qrCode);
			if(qrCode != null && qrCode.length() == 21 && qrCode.startsWith("51")) {
				// '51' barcode
				qrCode = (qrCode.substring(3));
			}

			if(qrCode.length() == 18 && qrCode.getBytes()[0] == 0x31) {
				//try barcode first
				String payCode = qrCode.substring(1);
				long uid = payCodeVerify(payCode);
				if(uid != -1) {
					System.out.println("uid="+uid);
				}
			}

			byte[] code = org.apache.commons.codec.binary.Base64.decodeBase64(qrCode);
			if(code[0] == '5' && code[1] == '1') {
				byte[] newCode = new byte[code.length-2];
				System.arraycopy(code, 2, newCode, 0, code.length-2);
				code = newCode;
			}

			//try qr code
			List<SmartCardItem> items = getSmartCardSegments(code);
			for(int i = 0; i < items.size(); i++) {
				SmartCardItem item = items.get(i);
				if(item.getSmartCardType().equals(SmartCardType.SMART_CARD_PAY.getCode())) {
					String payCode = new String(item.getSmartCardCode());
					long uid = payCodeVerify(payCode);
					if(uid != -1) {
						System.out.println("uid="+uid);
					} else {
					}
				}

			}

		} catch (Exception e) {

		}
	}

	private static List<SmartCardItem> getSmartCardSegments(byte[] code) {
		int i = 0, len, typ;
		Map<Integer, byte[]> segments = new HashMap<Integer, byte[]>();
		List<SmartCardItem> items = new ArrayList<SmartCardItem>();

		while(i+2 < code.length) {
			len = (int)code[i+1];
			if(len < 0 || (i+2+len) > code.length) {
				len = len + 256;
			}
			typ = (int)code[i];
			i += 2;
			byte[] seg = new byte[len];
			System.arraycopy(code, i, seg, 0, len);
			segments.put(new Integer(typ), seg);
			SmartCardItem item = new SmartCardItem();
			item.setSmartCardCode(seg);
			item.setSmartCardType((byte)typ);
			items.add(item);
			i += len;
		}

		return items;
	}
	private static long payCodeVerify(String payCode) {
		String randomUid = payCode.substring(0, 9);
		String totpCode = payCode.substring(9, 17);
		Long uid = Long.parseLong(randomUid);
		Long totpCodeInt = Long.parseLong(totpCode);
		uid = (uid ^ totpCodeInt);
		return uid;
	}

	private static TimeBasedOneTimePasswordGenerator getTotp() throws NoSuchAlgorithmException {
		TimeBasedOneTimePasswordGenerator totp = totpLocal.get();
		if(totp == null) {
			totp = new TimeBasedOneTimePasswordGenerator(stepInSecond, TimeUnit.SECONDS, 8);
			totpLocal.set(totp);
		}
		return totp;
	}

	private static int generateTotp(TimeBasedOneTimePasswordGenerator totp, String smartKey, long nowInSec) throws InvalidKeyException, NoSuchAlgorithmException {
		SecretKeySpec key = new SecretKeySpec(Base64.getDecoder().decode(smartKey.getBytes()), totp.getAlgorithm());
		int code = totp.generateOneTimePassword(key, new Date(nowInSec * 1000));
		return code;
	}

	/**
	 * 获取一卡通二维码
	 * @param keyTOTP
	 * @param isSupportPay
	 */
	public static String getQrCode(String keyTOTP, boolean isSupportPay) {
		// 1.用户UID与TOTP(K,C)进行异或运算，生成9位数字 RandomUID，RandomUID不足9位前面补0。
		// 2.'51'
		// 3.支付码
		String randomUID = createRandomUID(keyTOTP);
		byte[] preBytes = new byte[2];//新门禁支持51前缀，把51放出来
		preBytes[0] = '5';
		preBytes[1] = '1';
		byte[] payBytes = null;
		// 最终码数据
		byte[] segment = new byte[42];
		if (isSupportPay) {
			byte[] parQr = (randomUID + keyTOTP).getBytes();
			payBytes = new byte[2 + parQr.length];
			payBytes[0] = 1; // type = 1
			payBytes[1] = 17;
			System.arraycopy(parQr, 0, payBytes, 2, parQr.length);
		}
		segment[0] = '5';
		segment[1] = '1';
		System.arraycopy(payBytes, 0, segment, 0, payBytes.length);

		// 第三方码拼接 [type + len + (tag+code)]
		String cardCode = "/RIBAQAAAAAAAAPoXz6x7t/9wgc=";
		byte[] decodeCardCode = Base64.getDecoder().decode(cardCode);
		Integer tag = 11;
		byte tagByte = tag.byteValue();
		byte[] data = new byte[1 + decodeCardCode.length];
		data[0] = tagByte;
		System.arraycopy(decodeCardCode, 0, data, 1, decodeCardCode.length);
		// tag+data
		Integer dataLength = data.length;

		byte[] cardCodeBytes = new byte[2+dataLength];
		cardCodeBytes[0] = SmartCardType.SMART_CARD_CUSTOM.getCode();
		cardCodeBytes[1] = dataLength.byteValue();
		System.arraycopy(data, 0, cardCodeBytes, 2, data.length);
		System.arraycopy(cardCodeBytes, 0, segment, 19, cardCodeBytes.length);

		System.out.println(Arrays.toString(cardCodeBytes));
		System.out.println(Arrays.toString(segment));

		if (segment != null) {
			return encoder.encode(segment);
		}
		return "null";
	}


	//用户UID与TOTP(K,C)进行异或运算，生成9位数字 RandomUID，RandomUID不足9位前面补0。
	public static String createRandomUID(String key) {
		try {
			long uid = 1001L;
			long keyTOTP = Long.parseLong(key);
			long randomUID = uid ^ keyTOTP;
			String randomUIDStr = String.valueOf(randomUID);
			if (randomUIDStr.length() < 9) {
				randomUIDStr = "000000000".substring(0, 9 - randomUIDStr.length()) + randomUID;
			}
			return randomUIDStr;
		} catch (Exception e) {
		}
		return null;
	}
}

class SmartCardItem {
	private Byte smartCardType;
	private byte[] smartCardCode;

	public Byte getSmartCardType() {
		return smartCardType;
	}

	public void setSmartCardType(Byte smartCardType) {
		this.smartCardType = smartCardType;
	}

	public byte[] getSmartCardCode() {
		return smartCardCode;
	}

	public void setSmartCardCode(byte[] smartCardCode) {
		this.smartCardCode = smartCardCode;
	}
}

