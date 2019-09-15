package timeStampDateCalender;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2019/9/3 16:33
 */

public class test02 {
	public static void main(String[] args){
		Long time = 1566874106170L;
		Timestamp timestamp = new Timestamp(time);
		System.out.println(timestamp);
		System.out.println(timestamp.getTime());

		time = (time/1000)*1000;
		Timestamp timestamp2 = new Timestamp(time);
		System.out.println(timestamp2);
		System.out.println(timestamp2.getTime());


	}

	/**
	 * 获取精确到秒的时间戳
	 * @param date
	 * @return
	 */
	public static int getSecondTimestampTwo(Date date){
		if (null == date) {
			return 0;
		}
		String timestamp = String.valueOf(date.getTime()/1000);
		return Integer.valueOf(timestamp);
	}
}
