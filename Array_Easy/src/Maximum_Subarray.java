/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        // the possible sum that end with previous element
        int pre_largest_sum=nums[0];
        // keep track of the max of the max
        int max=pre_largest_sum;
        /* linear time scanning, if join the previous element would make it larger, joint it
        * otherwise just use itself */
        for(int i=1; i<nums.length; i++){
            if(nums[i]+pre_largest_sum>nums[i])
                pre_largest_sum=nums[i]+pre_largest_sum;
            else
                pre_largest_sum=nums[i];
            if(pre_largest_sum>max)
                max=pre_largest_sum;
        }
        return max;
    }
    public static void main(String[] args){
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(new Maximum_Subarray().maxSubArray(test));

    }

}
