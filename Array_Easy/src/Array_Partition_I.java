import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 Note:
 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].
 */

/* Since we try to maxima the sum of min, we should not waste any large values. So for any value, just assign a value that is slightly larger than it.
* So we sort the array first, and then sum every 2 values. */
public class Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int i=0;
        while(i< nums.length){
            result += nums[i];
            i+=2;
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = {1,4,3,2};
        System.out.print(new Array_Partition_I().arrayPairSum(test));
    }
}

