package timeUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author moubin.mo
 * @date: 2020/4/11 19:28
 */

public class TimeUtils {
	private final static String DEFAULT_TIME_FORMATTER = "yyyyMMddHHmm";

	/**
	 * <p>获取发布版本编号，格式：年月日时分秒</p>
	 */
	private String getPublishVersionNumber() {
		StringBuffer versionNumber = new StringBuffer();
		Calendar instance = Calendar.getInstance();
		versionNumber.append(instance.get(Calendar.YEAR));
		versionNumber.append(instance.get(Calendar.MONTH));
		versionNumber.append(instance.get(Calendar.DATE));
		versionNumber.append(instance.get(Calendar.HOUR));
		versionNumber.append(instance.get(Calendar.MINUTE));
		return versionNumber.toString();
	}

	public static String getPublishVersionNumberV2() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER);
		return LocalDateTime.now().format(df);
	}
}
