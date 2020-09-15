package date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2020/9/14 09:39
 */

public class TestDateNo {
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		System.out.println(df.format(new Date()));
	}
}
