import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class Target_Sum {
    /* dfs backtracking method, working, but slow */
//    int count = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++){
//            sum += nums[i];
//        }
//        if(sum < S){ return 0; }
//        Arrays.sort(nums);
//        findTargetSumWaysHelper(nums, sum - S, 0);
//        return count;
//    }
//    private void findTargetSumWaysHelper(int[] nums, int target, int pos){
//        if(target == 0){
//            count++;
//        }else if(target < 0 || pos == nums.length){ return; }
//        while(pos < nums.length){
//            /* for every position, change from + to -, result in 2*nums[pos] decrease */
//            findTargetSumWaysHelper(nums, target - 2 * nums[pos], pos + 1);
//            pos++;
//        }
//  }

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int S) {
        int[][] dp = new int[nums.length+1][S+1];
        dp[0][0] = 1;

        for(int i=1; i<=nums.length; i++){
            if(nums[i-1]==0)
                dp[i][0] = dp[i-1][0] * 2;
            else
                dp[i][0] = dp[i-1][0];
        }

        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=S; j++){
                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[nums.length][S];
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,0,1};
        System.out.print(new Target_Sum().findTargetSumWays(nums, 1));
    }
}
