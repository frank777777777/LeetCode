/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 */
public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, count=0;
        /* loop and count for every consecutive 1, and replace max if it goes greater than max */
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=1)
                count=0;
            else
                count++;
            if(count>max)
                max = count;
        }
        return max;
    }
    public static void main(String[] args){
        int[] test = {1,0,1,1,0,1};
        System.out.print(new Max_Consecutive_Ones().findMaxConsecutiveOnes(test));
    }
}
