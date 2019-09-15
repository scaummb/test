package leetCode;

import java.util.ArrayList;

/**
 * Date: 2019/4/30 19 :44
 *
 * @author moubin.mo
 */

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {

        // 1.负数 false
        boolean symbol = false;
        if (x < 0){
            return symbol;
        }

        // 2.正数
        int tmp = x;
        ArrayList<Integer> nums = new ArrayList<>();
        while (tmp > 0){
            if (tmp % 10 >= 0){
                nums.add(tmp % 10);//最低位靠前
            }
            tmp = tmp /10;
        }

        // 3.是否回文
        double result = 0.0;
        for(int i=0;i<nums.size();i++){
             result += (nums.get(i)*Math.pow(10,nums.size()-i-1));
        }

        symbol = ((result - x == 0))?true:false;
        return symbol;
    }

    public static void main(String[] args){
        int a = 10;
        boolean result = isPalindrome(a);
        System.out.println("result="+result);
    }
}
