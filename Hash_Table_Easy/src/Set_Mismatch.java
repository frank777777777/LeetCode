import java.util.Arrays;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

 Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

 Example 1:
 Input: nums = [1,2,2,4]
 Output: [2,3]
 Note:
 The given array size will in the range [2, 10000].
 The given array's numbers won't have any order.
 */
public class Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        /* Sort the array */
        Arrays.sort(nums);
        int[] result = new int[2];
        int difference=0;
        /* Do a full loop, sum all numbers from 1 to n, and minus the sum of the wrong nums array.
        * We get the difference between the duplicate number and the missing number.
        * Add the difference to the duplicate number */
        for(int i=0;i<nums.length-1;i++)
        {
            /* if there are two consecutive same number, it is the wrong one */
            if(nums[i]==nums[i+1]){
                result[0]=nums[i];
            }
            difference += i+1;      /* Avoid overflow */
            difference-=nums[i];
        }
        difference = difference + nums.length - nums[nums.length-1];    /* add and minus the last number */
        result[1]=result[0]+difference;
        return result;
    }
    public static void main(String[] args){
        int[] nums = {2,2,3,4};
        int[] result = new Set_Mismatch().findErrorNums(nums);
        System.out.println(result[0]);
        System.out.print(result[1]);
    }
}
