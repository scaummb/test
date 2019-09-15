package leetCode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * Date: 2019/4/28 09 :14
 *
 * @author moubin.mo
 */

public class twoSum {
    public static int[] twoSum(int[] nums, int target){
        for (int index = 0; index <= (nums.length -2) ; index++){
            int firstNum = nums[index];
            for (int index2 = index + 1;index2 <= nums.length -1; index2++){
                int secondNum = nums[index2];
                if (firstNum + secondNum == target){
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(index);
                    result.add(index2);
                    int[] d = new int[result.size()];
                    for(int i = 0;i<result.size();i++) {
                        d[i] = result.get(i);
                    }
                    return d;
                }
            }
        }
        return null;
    }

    public static int[] twoSumV2(int[] nums, int target){
        for (int index = 0; index <= (nums.length -2) ; index++){
            for (int index2 = index + 1;index2 <= nums.length -1; index2++){
                if (nums[index] + nums[index2] == target){
                    int d[] = new int[2];
                    d[0]=index;
                    d[1]=index2;
                    return d;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        int test[] = {3,2,4};
        int target = 6;
        int[] result = twoSum(test, target);
        System.out.println(JSONObject.toJSON(result));
    }
}
