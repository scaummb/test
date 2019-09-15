package leetCode;

import java.util.ArrayList;

/**
 * Date: 2019/4/29 21 :27
 *
 * @author moubin.mo
 */

public class IntegerInversion {

    public static int reverse(int x) {

        // 1.标识ture为正，false为false
        boolean symbol = true;
        if (x < 0){
            x = 0-x;
            symbol = false;
        }

        // 2.列表
        ArrayList<Integer> nums = new ArrayList<>();
        while (x>0){
            int a = x % 10; //取出最低位
            if (a >= 0){
                nums.add(0,a);//最低位靠前
            }
            x = x/10;
        }

        System.out.println("nums="+nums);

        // 3.逆转数字
        Double result = 0.0;
        for (int i=0; i <= nums.size()-1 ;i++){
            result += nums.get(i) * Math.pow(10,i);
            System.out.println("result="+result+" i="+i );

        }

        // 4.正数转负数
        if (!symbol){
            result = 0 - result;
        }

        // 5.溢出
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        }
        return result.intValue();
    }

    public static void main(String[] args){
        int val = -901000;
        int reverse = reverse(val);
        System.out.println("val="+val+"   result="+reverse);
    }
}
