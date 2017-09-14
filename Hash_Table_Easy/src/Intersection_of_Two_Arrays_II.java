import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Intersection_of_Two_Arrays_II {
    /* Method 1, sorted arrays */
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if(nums1.length==0 || nums2.length==0)
//            return new int[0];
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        LinkedList<Integer> list = new LinkedList<>();
//        int new_length=0;
//        int i=0,j=0;
//        while(i<nums1.length && j<nums2.length){
//            if(nums1[i]==nums2[j]){
//                list.add(nums1[i]);
//                new_length++;
//                i++;j++;
//            } else if(nums1[i]<nums2[j]){
//                i++;
//            } else if(nums1[i]>nums2[j]){
//                j++;
//            }
//        }
//        int[] result = new int[new_length];
//        int k=0;
//        for(Integer e:list){
//            result[k++]=e;
//        }
//        return result;
//    }

    /* Method 2, using set. Limited memory for nums2, only load element in nums one by one */
    public int[] intersect(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> map = new HashMap<>();
        /* put all values in nums1 to the set */
        for(int e:nums1){
            Integer value = map.get(e);
            if(value==null)
                map.put(e,1);
            else
                map.replace(e,value+1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        int new_length=0;
        for(int e:nums2){
            /* get the value, it it has value. Add it to the list and remove it from the hashmap if it is 1, decrease
            * by 1 if it is greater than 1 */
            Integer value =map.get(e);
            if(value!=null){
                new_length++;
                list.add(e);
                if(value==1){
                    map.remove(e,1);
                }else {
                    map.replace(e,value-1);
                }
            }
        }
        /* Convert the list to array */
        int[] result = new int[new_length];
        int k=0;
        for(Integer e:list){
            result[k++]=e;
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums1 = {54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41};
        int[] nums2 = {17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20};
        int[] result = new Intersection_of_Two_Arrays_II().intersect(nums1,nums2);
        for(int e:result){
            System.out.print(e+" ");
        }
    }
}
