package effectivejava.no5;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author moubin.mo
 * @date: 2020/12/20 12:29
 */

public class Person2 {
	private final Date birthDate;
	private static final Date BOOM_START = null;
	private static final Date BOOM_END = null;

	//静态代码块，执行一次
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
	}

	public Person2(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isBababyBoomer() {
		return (birthDate.compareTo(BOOM_START) >= 0) && (birthDate.compareTo(BOOM_END) < 0);
	}
}
