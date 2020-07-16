package timestamp;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;

/**
 * @author moubin.mo
 * @date: 2020/7/16 10:10
 */

public class Test {
	public static void main(String[] args) {
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		System.out.println(timestamp);
		System.out.println(parseTimeStamp("2020-07-16 10:13:21"));
	}
	/**
	 * <p>字符串转TimeStamp</p>
	 */
	public static Timestamp parseTimeStamp(String time) {
		if (!StringUtils.isEmpty(time)){
			return Timestamp.valueOf(time);
		}
		return null;
	}
}
