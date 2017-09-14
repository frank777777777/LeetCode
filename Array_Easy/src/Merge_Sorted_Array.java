/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /* i and j are two pointers, k is the last postion */
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0 && j>=0)
            /* choose the greater among nums1 and nums2, and put into the last position */
            nums1[k--] = nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
        /* if i finished before j, then we should put the remaining of nums2 into num1
        * ir j finished before i, then we are done since num1 are already there */
        while (j>=0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args){
        int[] nums1 = {0};
        int[] nums2 = {1};
        new Merge_Sorted_Array().merge(nums1,0,nums2,1);
        for(int i: nums1)
            System.out.print(i+" ");
    }
}
