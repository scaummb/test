package leetCode.algorithm;

import java.util.HashMap;
import java.util.Set;

/**
 * REMARK leetcode 729. 我的日程安排表 I
 *
 * @author: mmb
 * @date: 19-12-23
 */
class MyCalendar {

    private static HashMap<Integer, Integer[]> startTime = new HashMap<>(101);
    private static HashMap<Integer, Boolean> endTime = new HashMap<>(101);

    public MyCalendar() {

    }

    public static boolean book(int start, int end) {
        end = end-1;
        if (startTime.get(start) == null && endTime.get(end) == null
            && start >= 0 && end >= 0 && start <= end){
            Set<Integer> startTimeKeys = startTime.keySet();
            for (Integer time : startTimeKeys){
                Integer[] element = startTime.get(time);
                if ((element[0] <= start && start <= element[1])
                        ||  (element[0] <= end && end <= element[1])
                        || (element[0] <= start && end <= element[1])){
                    return false;
                }
            }
            startTime.put(start, new Integer[]{start, end-1});
            endTime.put(end, false);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{};
        // testcase 1
//        print(book(10, 20));
//        print(book(15, 25));
//        print(book(20, 30));
        // testcase 2
//[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        print(book(47,50));
        print(book(33,41));
        print(book(39,45));
        print(book(33,42));
        print(book(25,32));// error
        print(book(26,35));
        print(book(19,25));// error
        print(book(3,8));
        print(book(8,13));
        print(book(18,27));
    }

    private static void print(Object object){
        System.out.println(object);
    }
}
