/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 */
public class Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length<k)
            return Double.MIN_VALUE;
        /* calculate the first k values */
        int sum=0;
        for(int i=0;i<k;i++) sum+=nums[i];

        /* we can assume the k values as a chunk, as we more to check the value of the next chunk
        * we add the new value, and subtract the previous value. If this is greater then max, set it to max */
        int max=sum;
        for(int i=1;i<=nums.length-k;i++){
            sum= sum-nums[i-1]+nums[i+k-1];
            if(sum>max)
                max=sum;
        }
        return (double)max/k;
    }
    public static void main(String[] args){
        int[] nums = {1,12,-5,-6};
        System.out.print(new Maximum_Average_Subarray_I().findMaxAverage(nums,4));
    }

}
