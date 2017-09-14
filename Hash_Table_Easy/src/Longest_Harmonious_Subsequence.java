import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class Longest_Harmonious_Subsequence {
    /* Using hashmap, O(n) time*/
//    public int findLHS(int[] nums) {
//        int max=0;
//        int count_low,count_high,count_current;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i:nums){
//            /* For every i, put i as a key, and its counts as the value */
//            map.put(i,map.getOrDefault(i,0)+1);
//            /* get the count sum of i-1, i, i+1, see if the sum is greater than max */
//            count_low=map.getOrDefault(i-1,0);
//            count_high=map.getOrDefault(i+1,0);
//            count_current=map.get(i);
//            if(count_low!=0 && count_low+count_current>max)
//                max=count_low+count_current;
//            if(count_high!=0 && count_high+count_current>max)
//                max=count_high+count_current;
//        }
//        return max;
//    }

    /* Log(nlogn) running time, beats 99.11% of submission. But the running time will increase a lot for larger input */
    public int findLHS(int[] nums){
        int current_count=1;
        int previous_count=0;
        int max_count=0;
        /* Sort it first, O(nlogn) */
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            /* If increment is 1, store the previous continuous count, and starts count and current run */
            if(nums[i]-nums[i-1]==1){
                previous_count=current_count;
                current_count=1;
                /* if it is the same as the previous, increment the current count*/
            } else if(nums[i]==nums[i-1]){
                current_count++;
                /* If the increment in value is greater than 1, the previous count cannot be used set it to 0, and current
                * to 1*/
            } else {
                previous_count=0;
                current_count=1;
            }
            /* Only if there is min value and max value, so the previous account must exist, so it cannot be 0 */
            if(previous_count!=0 && current_count+previous_count>max_count)
                max_count=current_count+previous_count;
        }
        return max_count;
    }
    public static void main(String[] args){
        int[] nums = {2,1,1,3,3,3};
        System.out.print(new Longest_Harmonious_Subsequence().findLHS(nums));
    }
}
