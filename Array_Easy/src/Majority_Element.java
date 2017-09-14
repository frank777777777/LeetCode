import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Majority_Element {
    /* moore voting algorithm*/
    public int majorityElement(int[] nums) {
        /* initialize the first element as a vote, for every element matches, get one more vote, otherwise one less vote
        * if the vote is 0, means this element is outvoted by others, thus we choose another element and vote again */
        int vote=1;
        int majority= nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]==majority)
                vote++;
            else{
                vote--;
                if(vote==0){
                    vote++;
                    majority = nums[i];
                }
            }
        }
        return majority;
    }
    public static void main(String[] args){
        int[] test = {8,7,8,7,8,5};
        System.out.print(new Majority_Element().majorityElement(test));
    }

    /* bit manipulation. For every appearance of the element, add its bits to the map. For bits has not appears half of the time, wipe it to zeros, and convert it back to decimal */
//    public int majorityElement(int[] nums) {
//        int[] bit = new int[32];
//        for (int num: nums)
//            for (int i=0; i<32; i++)
//                if ((num>>(31-i) & 1) == 1)
//                    bit[i]++;
//        int ret=0;
//        for (int i=0; i<32; i++) {
//            bit[i]=bit[i]>nums.length/2?1:0;
//            ret += bit[i]*(1<<(31-i));
//        }
//        return ret;
//    }


    /* Sorting algorithm, because there must be a majority element, it must be the middle element after sorting */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        /* Since there is always a majority, the majority element must be in the middle */
//        return nums[nums.length/2];
//    }


    /* sorting algorithm, return -1 ir no majority */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int half_length = nums.length/2;
//        int bound = nums.length-half_length;
//        for(int i=0;i<bound;i++){
//            if(nums[i]==nums[i+half_length])
//                return nums[i];
//        }
//        return -1;
//    }




    /* hashmap implementation, slow because of the overhead of building hashmap and computing hash value */
    /*public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int half_length = nums.length/2;
        for(int i: nums){
            if(map.containsKey(i)){
                map.replace(i,map.get(i)+1);
                if(map.get(i)>half_length)
                    return i;
            }
            else{
                map.put(i,1);
                if(map.get(i)>half_length)
                    return i;
            }
        }
        return -1;
    }*/
}
