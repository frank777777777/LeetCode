import java.util.Arrays;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

 Example 1:
 Input: [3, 1, 4, 1, 5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.
 Example 2:
 Input:[1, 2, 3, 4, 5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 Example 3:
 Input: [1, 3, 1, 5, 4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).
 Note:
 The pairs (i, j) and (j, i) count as the same pair.
 The length of the array won't exceed 10,000.
 All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class K_diff_Pairs_in_an_Array {
    /* Sorting method, sort first, using O(nlogn) time, and then linear scan elements, and check neighbors */
    public int findPairs(int[] nums, int k) {
        /* sort, and check for array size for early return */
        Arrays.sort(nums);
        if(nums.length<2 || nums[nums.length-1]-nums[0]<k)
            return 0;
        int count=0;
        int i=0,j=1;
        while(i<nums.length-1){
            /* if j is behind i, put it 1 position ahead, otherwise leave it there */
            /* if num[j]-nums[i] is less than k, for any i value between the i and j,nums[j]-nums[i] will be less than k
             * we do not need to check that again. Just make sure j is always ahead of i, since sometimes i skips duplicates */
            j= j>=i ? j : i+1;
            while(j<nums.length){
                if(nums[j]-nums[i]==k){
                    count++;
                    break;
                }
                /* if the difference is greater than k, means j is being added one more, so change it back */
                if(nums[j]-nums[i]>k){
                    j--;
                    break;
                }
                j++;
            }
            /* skip all the duplicate values */
            while(i<nums.length-1 && nums[i]==nums[i+1])
                i++;
            i++;
        }
        return count;
    }

    public static void main(String[] args){
        int[] nums = {1, 1, 1, 1, 1};
        System.out.print(new K_diff_Pairs_in_an_Array().findPairs(nums,0));

    }
}
