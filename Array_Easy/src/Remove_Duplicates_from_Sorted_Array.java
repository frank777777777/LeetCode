/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        /* check for empty */
        if(nums.length==0)
            return 0;
        /* Pointer goes along and locate new position, it is the current length as well */
        int pointer=1;
        int current = nums[0];
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=current){
                current=nums[i];
                nums[pointer]=current;
                pointer++;
            }
        }
        return pointer;
    }
    public static void main(String[] args){
        int[] nums = {};
        int new_length = new Remove_Duplicates_from_Sorted_Array().removeDuplicates(nums);
        for(int i=0;i<new_length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
