//package version_control;
//
///**
// * Date:   2018/10/15
// * Author: xueyunfeng
// * About:  一卡通工具类
// */
//public class SmartCardUtils {
//	private final static String TAG = SmartCardUtils.class.getSimpleName();
//
//	/**
//	 * 获取一卡通条形码
//	 *
//	 * @param context
//	 * @param keyTOTP
//	 * @return
//	 */
//	public static String getBarCode(Context context, String keyTOTP) {
//		String randomUID = createRandomUID(context, keyTOTP);
//		//条形码
//		return "511" + randomUID + keyTOTP;
//	}
//
//	/**
//	 * 获取一卡通二维码
//	 *
//	 * @param context
//	 * @param keyTOTP
//	 * @param smartCardHandlers
//	 * @param isSupportAccess
//	 * @param isSupportPay
//	 * @return
//	 */
//	public static String getQrCode(Context context, String keyTOTP, List<SmartCardHandler> smartCardHandlers, boolean isSupportAccess, boolean isSupportPay) {
//		String randomUID = createRandomUID(context, keyTOTP);
//		byte[] preBytes = new byte[2];//新门禁支持51前缀，把51放出来
//		preBytes[0] = '5';
//		preBytes[1] = '1';
//		byte[] payBytes = null;
//		byte[] businessSegments = null;
//		if (isSupportPay) {
//			byte[] parQr = (randomUID + keyTOTP).getBytes();
//			payBytes = new byte[2 + parQr.length];
//			payBytes[0] = 1;
//			payBytes[1] = 17;
//			System.arraycopy(parQr, 0, payBytes, 2, parQr.length);
//		}
//
//		if (isSupportAccess) {
//			if (smartCardHandlers != null) {
//				for (SmartCardHandler smartCardHandler : smartCardHandlers) {
//					businessSegments = SmartCardModuleController.getBusinessSegment(SmartCardModuleController.getBusinessHandler(smartCardHandler, true), true);
//				}
//			}
//		}
//		byte[] segment = null;
//		if (payBytes != null && businessSegments != null) {
//			segment = new byte[preBytes.length + payBytes.length + businessSegments.length];
//			System.arraycopy(preBytes, 0, segment, 0, preBytes.length);
//			System.arraycopy(payBytes, 0, segment, preBytes.length, payBytes.length);
//			System.arraycopy(businessSegments, 0, segment, preBytes.length + payBytes.length, businessSegments.length);
//		} else if (payBytes != null) {
//			segment = new byte[preBytes.length + payBytes.length];
//			System.arraycopy(preBytes, 0, segment, 0, preBytes.length);
//			System.arraycopy(payBytes, 0, segment, preBytes.length, payBytes.length);
//		} else if (businessSegments != null) {
//			segment = new byte[preBytes.length + businessSegments.length];
//			System.arraycopy(preBytes, 0, segment, 0, preBytes.length);
//			System.arraycopy(businessSegments, 0, segment, preBytes.length, businessSegments.length);
//		}
//		if (segment != null) {
//			return Base64.encodeToString(segment, Base64.NO_WRAP);
//		}
//		return "null";
//	}
//
//	/**
//	 * 获取拓展卡片二维码
//	 *
//	 * @param smartCardHandler 对应业务处理之后的数据
//	 * @return
//	 */
//	public static String getExtendQrCode(SmartCardHandler smartCardHandler) {
//		byte[] businessSegments = SmartCardModuleController.getBusinessSegment(smartCardHandler, false);
//		if (businessSegments != null) {
//			return Base64.encodeToString(businessSegments, Base64.NO_WRAP);
//		}
//		return "null";
//	}
//
//
//	//采用TOTP算法加密密钥key，生成一个8位数字的随机数。
//	public static String createKeyTOTP(String key) {
//		String keyTOTP = "";
//		if (key != null) {
//			ELog.d(TAG, "smartCardKey = " + key);
//			long curTime = System.currentTimeMillis();
//			ELog.d(TAG, "curTime = " + curTime);
//			keyTOTP = TOTP.generateTOTP(key, curTime, CardPreferences.TIME_PERIOD, "8", "HmacSHA1");
//		}
//		ELog.d(TAG, "keyTOTP = " + keyTOTP);
//		return keyTOTP;
//	}
//
//	//用户UID与TOTP(K,C)进行异或运算，生成9位数字 RandomUID，RandomUID不足9位前面补0。
//	public static String createRandomUID(Context context, String key) {
//		try {
//			long uid = LocalPreferences.getUid(context);
//			long keyTOTP = Long.parseLong(key);
//			long randomUID = uid ^ keyTOTP;
//			String randomUIDStr = String.valueOf(randomUID);
//			if (randomUIDStr.length() < 9) {
//				randomUIDStr = "000000000".substring(0, 9 - randomUIDStr.length()) + randomUID;
//			}
//			ELog.d(TAG, "uid = " + uid);
//			ELog.d(TAG, "randomUIDStr = " + randomUIDStr);
//			return randomUIDStr;
//		} catch (Exception e) {
//			ELog.d(TAG, "createRandomUID  " + e.toString());
//		}
//		return null;
//	}
//}
