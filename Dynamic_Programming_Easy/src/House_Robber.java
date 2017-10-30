/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.*/
public class House_Robber {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 0) return 0;
        int[] max = new int[length];
        /* Since the robbed houses cannot be adjacent,prev1 is the house go backwards by 3, prev2 is the house go backwards by 2.
        * The max amount the current sum can have, is the max between prev1 and prev2, plus the current house */
        int prev1; int prev2;
        for(int i = 0; i < length; i++){
            prev1 = i - 3 < 0 ? 0 : max[i - 3];
            prev2 = i - 2 < 0 ? 0 : max[i - 2];
            max[i] = Math.max(prev1,prev2) + nums[i];
        }
        return Math.max(max[length - 1], max[length - 2]);
    }

    /* non DP, actually works */
//    public static int rob(int[] nums)
//    {
//        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
//        int ifDidntRobPrevious = 0; // max money can get if not rob current house
//
//        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
//        for(int i=0; i < nums.length; i++)
//        {
//            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
//            int currRobbed = ifDidntRobPrevious + nums[i];
//
//            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
//            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);
//
//            // Update values for the next round
//            ifDidntRobPrevious  = currNotRobbed;
//            ifRobbedPrevious = currRobbed;
//        }
//
//        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
//    }

    public static void main(String[] args){
        int[] nums = new int[]{4,6,8,3,5,7,1};
        System.out.println(new House_Robber().rob(nums));
    }
}
