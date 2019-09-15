package date;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author moubin.mo
 * @date: 2019/8/12 22:39
 */

public class TimeStampTest {
    public static void main(String[] args){
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timeStamp.toLocalDateTime();
//        System.out.println("localDateTime="+localDateTime.getYear()+localDateTime.getMonth()+localDateTime.getDayOfMonth()+localDateTime.getMonth()+localDateTime.getHour()+localDateTime.getMinute());

        System.out.println(timeStamp.toString());


    }
}
