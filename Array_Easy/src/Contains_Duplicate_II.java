import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class Contains_Duplicate_II {


    public boolean containsNearbyDuplicate(int[] nums, int k) {

        /* Using hashset, start removing value after i greater than k. Therefore, maintaining a set of size k.
        * When failed to add the number into the set, means there is a duplicate */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
    /* using hashmap, slow but intuitive */
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer,Integer> myMap = new HashMap<>();
//        for(int i=0; i<nums.length;i++){
//            /* if any number has happened, check the index difference less than k, if greater, then put the number and index
//            * into the hashmap*/
//            if(myMap.containsKey(nums[i])){
//                if(i-myMap.get(nums[i])<=k)
//                    return true;
//                else
//                    myMap.replace(nums[i],i);
//            }
//            /* if the number never happened, put the value and index into the hashmap */
//            else
//                myMap.put(nums[i],i);
//        }
//        return false;
//    }
    public static void main(String[] args){
        int[] nums= {1,4,5,6,7,8,4,0,1,84,67,43};
        int k=7;
        System.out.print(new Contains_Duplicate_II().containsNearbyDuplicate(nums,k));
    }
}
