import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 */
public class Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2)
            return 0;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int i=0,j=copy.length-1;
        while(i<j){
            if (copy[i]==nums[i])
                i++;
            else if(copy[j]==nums[j])
                j--;
            else
                break;
        }
        if(i==j)
            return 0;
        else
            return j-i+1;
    }
    public static void main(String[] args){
        int[] nums = {2,4,5,8,9,10,15};
        System.out.print(new Shortest_Unsorted_Continuous_Subarray().findUnsortedSubarray(nums));
    }
}
