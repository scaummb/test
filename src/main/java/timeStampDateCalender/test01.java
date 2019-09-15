package timeStampDateCalender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date: 2019/4/24 15 :03
 *
 * @author moubin.mo
 * @Todo 时间工具类使用
 */

public class test01 {
    public static final Logger LOGGER = LoggerFactory.getLogger(test01.class);

    public static void main(String[] args) throws ParseException {
        //1 Java.util.Date
        String dateStr = "2013-8-13 23:23:23";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(dateStr);
        String dateString = dateFormat.format(date);
        LOGGER.debug("[1]  date={},dateString={}",date,dateString);

        //2 Java.sql.Date
        // java.util.Date转换为java.sql.Date
        java.sql.Date date2 = new java.sql.Date(date.getTime());// 其中utilDate为java.util.Date类型的对象
        LOGGER.debug("[2]  date2={}",date2);

        //3 Java.util.Calendar
        // Date转为Calendar
        Date date1=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date1);
        // Calendar转为Date
        Calendar ca=Calendar.getInstance();
        Date date3 =(Date) ca.getTime();
        LOGGER.debug("[3]  date1={}，calendar={}，ca={}, date3={}",date1,calendar,ca,date3);

        //4 Java.sql.Timestamp
        // java.util.Calendar转换为java.sql.Timestamp
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
        // java.util.Date转换为java.sql.Timestamp
        Timestamp timestamp1 = new Timestamp(date.getTime());

        // String转换为java.sql.Timestamp，String格式：yyyy-mm-dd hh:mm:ss[.f...] ，方括号表示可选
        Timestamp.valueOf("2013-07-06 01:49:30");
        LOGGER.debug("timestamp={},  timestamp1={}",timestamp,timestamp1);
    }
}
