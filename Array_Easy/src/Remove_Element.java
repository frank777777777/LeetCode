/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length; i++){
            /* put the new found non-val value to index count, and increment. */
            if(nums[i]!=val){
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] test_nums = {3,2,2,3};
        int val = 2;
        int new_length = new Remove_Element().removeElement(test_nums,val);
        for(int i=0;i<new_length;i++){
            System.out.print(test_nums[i]);
        }
    }
}
