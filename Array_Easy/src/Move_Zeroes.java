/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        /* search for every non-zero value, and put it int the front. Using counter to keep track of the position */
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[counter]=nums[i];
                counter++;
            }
        }
        /* fill the rest position with 0s */
        for(;counter<nums.length;counter++){
            nums[counter]=0;
        }
    }
    public static void main(String[] args){
        int[] test = {0,1,0,3,12};
        Move_Zeroes test_obj = new Move_Zeroes();
        test_obj.moveZeroes(test);
        for(int i:test)
            System.out.print(i+",");
    }
}
