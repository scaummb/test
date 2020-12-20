package effectivejava.no5;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author moubin.mo
 * @date: 2020/12/20 12:23
 */
//反例
public class Person {
	private final Date birthDate;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isBababyBoomer(){
		//每次调用方法，执行一次
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1,0,0,0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1,0,0,0);
		Date boomEnd = gmtCal.getTime();
		return (birthDate.compareTo(boomStart) >= 0) && (birthDate.compareTo(boomEnd)<0);
	}
}
