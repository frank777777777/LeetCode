import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
/* Basically, using the value as flag to mark every integer that appears, and convert it back if necessary */
public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        final int n = nums.length;
        int temp;
        for(int i=0; i<n; i++){
            /* convert all number to its original value, regardless it is added n or not */
            temp = nums[i]-n>0 ? nums[i]-n : nums[i];
            /* For every value appears, add n to the value in which the appearing value refers to */
            if(nums[temp-1]<n+1) nums[temp-1]+=n;
        }
        /* For every value that has not been added n, the index+1 is the value that did not appear */
        for(int i=0; i<n; i++){
            if(nums[i]<n+1) result.add(i+1);
        }
        return result;
    }
    public static void main(String[] args){
        int[] test = {4,3,2,7,8,2,3,1};
        List retult = new Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers(test);
    }
}
