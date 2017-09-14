import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class Intersection_of_Two_Arrays {
    /* Time complexity, O(M+N)*/
    public int[] intersection(int[] nums1, int[] nums2) {
        /* set_nums stores a set of elements in nums1, while result stores the return elements, so ensure uniqueness */
        HashSet<Integer> set_Nums = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        /* add all elements in nums1 in set_nums */
        for(int i:nums1)
            set_Nums.add(i);
        /* Iterate through nums2, if the elements already in the set, put it the result set */
        for(int i:nums2){
            if(set_Nums.contains(i)){
                result.add(i);
            }
        }
        int size = result.size();
        int intersection[] = new int[size];
        int k=0;
        for(int value:result){
            intersection[k++]=value;
        }
        return intersection;
    }
    public static void main(String[] args){
        int[] nums1={1};
        int[] nums2={1,1};
        int[] result = new Intersection_of_Two_Arrays().intersection(nums1,nums2);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
}
