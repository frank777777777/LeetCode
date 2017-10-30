import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.*/
public class Range_Sum_Query_Immutable {
    public static void main(String[] args){
        int[] nums = new int[]{3,4,6,3,5,7,9};
        NumArray arr = new NumArray(nums);
        System.out.println(arr.sumRange(0,0));
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        i = i < 0 ? 0 : i;
        j = j > nums.length-1 ? nums.length-1 : j;
        if(i == 0)
            return nums[j];
        return nums[j] - nums[i-1];

    }
}



/* 2-d array, using too much memory */
//class NumArray {
//    int[][] dp = null;
//    public NumArray(int[] nums) {
//        if(nums.length != 0){
//            dp = new int[nums.length][nums.length];
//            dp[0][0] = nums[0];
//            for(int i = 1; i < nums.length; i++){
//                dp[0][i] = dp[0][i-1] + nums[i];
//                for(int j = 1; j <= i; j++){
//                    dp[j][i] = dp[j-1][i] - nums[j-1];
//                }
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if(dp == null){
//            return 0;
//        }
//        if(i < 0) i = 0;
//        if(j > dp.length - 1) j = dp.length - 1;
//        return dp[i][j];
//    }
//}
