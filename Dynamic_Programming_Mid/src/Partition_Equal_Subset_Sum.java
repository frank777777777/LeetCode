import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.*/
public class Partition_Equal_Subset_Sum {
    boolean res = false;
    public boolean canPartition(int[] nums) {
        long sum = 0;
        for(int i : nums){
            sum += i;
        }
        /* if not even return false */
        if((sum & 1) != 0){ return false; }
        Arrays.sort(nums);
        helper(nums, sum / 2, 0);
        return res;
    }
    private void helper(int[] nums, long sum, int pos){
        if(sum == 0){
            res = true;
            return;
        }
        if(sum < 0 || pos == nums.length){ return; }
        /* if res is true, means we already found it, do not continue BFS */
        while(pos < nums.length && !res){
            helper(nums, sum - nums[pos], pos + 1);
            /* skip duplicates */
            while(pos + 1 < nums.length && nums[pos] == nums[pos + 1]){ pos++; }
            pos++;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,18,66,62,55,19,2,67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,58,55,73,74,97,49,71,42,26,8,87,99,1,16,79};
        System.out.print(new Partition_Equal_Subset_Sum().canPartition(nums));
    }
}
