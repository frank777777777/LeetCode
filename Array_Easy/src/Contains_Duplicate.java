import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

/* Sort the array, the check every adjacent elements to see if they are the same. The running time depend on the sorting algorithm */
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<2)
            return false;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i])
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] test ={1,2,3,4,5,6,7,9};
        System.out.print(new Contains_Duplicate().containsDuplicate(test));
    }
}
