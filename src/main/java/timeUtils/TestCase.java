package timeUtils;

import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * REMARK
 *
 * @author: mmb
 * @date: 19-12-15
 */
public class TestCase {
    private final static Gson gson = new Gson();

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    private static void test01() {
        //取今天0点到第二天0点的数据
        Timestamp remindEndTime = new Timestamp(DateStatisticHelper.getCurrent0Hour().getTime() + 24*3600*1000L);
        Timestamp remindStartTime = new Timestamp(DateStatisticHelper.getCurrent0Hour().getTime());
        systemout(remindEndTime, remindStartTime);
        Long count = 1L;
        test(count++);
    }

    public static void test(Long count){
        systemout(count);
    }

    public static void systemout(Object... object){
        System.out.println(gson.toJson(object));
    }

    public static Timestamp test02(){
        Integer remindSetting = 0;
        Timestamp planDate = new Timestamp(System.currentTimeMillis());
        /**根据remindSetting 和 planDate 生成提醒时间*/
        Calendar calendar = getPlanDateCalendar(planDate,remindSetting);

        calendar.add(Calendar.DATE, remindSetting * (-1));
        calendar.set(Calendar.MILLISECOND, 0);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis() - 3600000L);
        systemout(timestamp);
        return timestamp;
    }

    private static Calendar getPlanDateCalendar(Timestamp planDate, Integer remindSetting) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(planDate.getTime());
        if(null != remindSetting){
            Calendar setting = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, setting.get(Calendar.HOUR));
            calendar.set(Calendar.MINUTE, setting.get(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, setting.get(Calendar.SECOND));
        }
        return calendar;

    }

    public static void test03(){
        Calendar calendar = Calendar.getInstance();
        systemout(calendar.getTimeInMillis());
        calendar.set(Calendar.YEAR, 2020);
        systemout(calendar.getTimeInMillis());
    }
}
