/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number {
    /* since a^b^b=a, so every number do a xor operation with xor, those appears twice will cancel out, the single one will left */
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums)
            xor^= num;
        return xor;
    }

    public static void main(String[] args){
        int[] nums = {1};
        System.out.print(new Single_Number().singleNumber(nums));
    }
}
