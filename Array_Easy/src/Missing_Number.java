/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

/* a^b^b =a, since a xor b xor b =a, so a^b^b^c^c^d^d.....=a. So we use xor for every i and nums[i]. That variable xor become is the number that is missing */
public class Missing_Number {
    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ nums.length;
    }
//    public int missingNumber(int[] nums) {
//        boolean zero=false;
//        int difference = nums.length+1;
//        for(int i=0;i<nums.length;i++){
//            int value = nums[i]>nums.length ? nums[i]-difference : nums[i];
//            if(value!=0){
//                nums[value-1] = nums[value-1]+difference;
//            }
//            else
//                zero=true;
//        }
//        if(zero==false)
//            return 0;
//        for(int i=0; i<nums.length;i++)
//        {
//            if(nums[i]<=nums.length)
//                return i+1;
//        }
//        return -1;
//    }

    public static void main(String[] args){

//        System.out.print(2^0);
        int[] test = {0,1,5,3,4};
        System.out.print(new Missing_Number().missingNumber(test));
    }
}
