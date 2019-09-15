package leetCode;

/**
 * Date: 2019/5/19 16 :03
 *
 * @author moubin.mo
 */

public class RemovingDuplicateElements {
    public static void main(String [] args){
        int[] nums = {3,2,2,3};
        int val = 3;
//        int result = removeElement(nums, val);
        int result = removeElementV2(nums, val);
        System.out.println("result="+result);
    }

    private static int removeElement(int[] nums, int val) {
        //双指针
        int i = 0;  //快指针
        int j = 0;  //慢指针
        for (;i<nums.length;i++){
            if (nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    //当要删除的元素很少时
    //例如，num=[1，2，3，5，4]，Val=4num=[1，2，3，5，4]，Val=4。之前的算法会对前四个元素做不必要的复制操作。
    //另一个例子是 num=[4，1，2，3，5]，Val=4num=[4，1，2，3，5]，Val=4。
    // 似乎没有必要将 [1，2，3，5][1，2，3，5] 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
    private static int removeElementV2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return n;
    }

}
