import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class Rotate_Array {
    /* Better Solution, O(n) time and O(1) space*/
    public void rotate(int[] nums, int k){
        /* compute the offset */
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int [] nums, int start, int end){
        int temp;
        while(start<end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }



    /* O(n) time and O(n) space */
    /*public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        for(int i=0;i<nums.length;i++) {
            *//* Compute the offset, from the array copy, put values back according to new position *//*
            int new_position = (i+k)%nums.length;
            nums[new_position] = copy[i];
        }
    }*/
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        new Rotate_Array().rotate(nums,3);
        for(int value:nums){
            System.out.print(value+" ");
        }
    }
}
