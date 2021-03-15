package timestamp;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author moubin.mo
 * @date: 2020/7/16 10:10
 */

public class Test {
	public static void main(String[] args) {
//		DayDTO oneDayTimestamp = getOneDayTimestamp(System.currentTimeMillis());
//		System.out.println(new Date(oneDayTimestamp.getOnedayBeforeTimestamp()));
//		System.out.println(new Date(oneDayTimestamp.getCurrentTimestamp()));
		MonthDTO oneMonthTimestamp = getOneMonthTimestamp(System.currentTimeMillis());
		System.out.println(new Date(oneMonthTimestamp.getCurrentTimestamp()));
		System.out.println(new Date(oneMonthTimestamp.getOneMonthAfterTimestamp()));
	}

	/**
	 * <p>
	 * 获取当前时间所在月份的开始结束时间
	 * </p>
	 */
	private static MonthDTO getOneMonthTimestamp(long currentTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(currentTime);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(GregorianCalendar.MINUTE, 0);
		cal.set(GregorianCalendar.SECOND, 0);
		cal.set(GregorianCalendar.MILLISECOND, 0);
		long time1 = cal.getTimeInMillis();
		cal.add(GregorianCalendar.MONTH, 1);
		long time2 = cal.getTimeInMillis();
		return new MonthDTO(time1, time2);
	}


	private static DayDTO getOneDayTimestamp(long currentTimeMillis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(currentTimeMillis);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long time1 = cal.getTimeInMillis();
		cal.add(GregorianCalendar.DAY_OF_MONTH, -1);
		long time2 = cal.getTimeInMillis();
		return new DayDTO(time2, time1);
	}

	/**
	 * <p>字符串转TimeStamp</p>
	 */
	public static Timestamp parseTimeStamp(String time) {
		if (!StringUtils.isEmpty(time)) {
			return Timestamp.valueOf(time);
		}
		return null;
	}
}

/**
 * <ul>
 * <li>onedayBeforeTimestamp: onedayBeforeTimestamp</li>
 * <li>currentTimestamp: currentTimestamp</li>
 * </ul>
 */
class DayDTO {
	private long onedayBeforeTimestamp;
	private long currentTimestamp;

	public DayDTO(long onedayBeforeTimestamp, long currentTimestamp) {
		this.onedayBeforeTimestamp = onedayBeforeTimestamp;
		this.currentTimestamp = currentTimestamp;
	}

	public long getOnedayBeforeTimestamp() {
		return this.onedayBeforeTimestamp;
	}

	public void setOnedayBeforeTimestamp(long onedayBeforeTimestamp) {
		this.onedayBeforeTimestamp = onedayBeforeTimestamp;
	}

	public long getCurrentTimestamp() {
		return this.currentTimestamp;
	}

	public void setCurrentTimestamp(long currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}
}


/**
 * <ul>
 * <li>currentTimestamp: 当前时间</li>
 * <li>oneMonthAfterTimestamp: 一个月后时间</li>
 * </ul>
 */
class MonthDTO {
	private long currentTimestamp;
	private long oneMonthAfterTimestamp;

	public MonthDTO(long currentTimestamp, long oneMonthAfterTimestamp) {
		this.currentTimestamp = currentTimestamp;
		this.oneMonthAfterTimestamp = oneMonthAfterTimestamp;
	}

	public long getCurrentTimestamp() {
		return currentTimestamp;
	}

	public void setCurrentTimestamp(long currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}

	public long getOneMonthAfterTimestamp() {
		return oneMonthAfterTimestamp;
	}

	public void setOneMonthAfterTimestamp(long oneMonthAfterTimestamp) {
		this.oneMonthAfterTimestamp = oneMonthAfterTimestamp;
	}
}