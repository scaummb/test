package algorithm.numberCarry.wiggle;

class WiggleMaxLengthSolution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <2){
            return n;
        }
        int up = 1;
        int down = 1;
        //遍历数组
        for (int i = 1; i<n; i++){
            //当前数 大于 前一个数
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }
            //当前数 小于 前一个数
            if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}