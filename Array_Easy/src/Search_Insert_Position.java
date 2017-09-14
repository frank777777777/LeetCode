import java.util.Arrays;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int start=0, end=nums.length-1, mid=0;
        /* binary search */
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        /* start and end would converge. It the point they converge is smaller than target, then insert into mid+1,
        * otherwise insert to mid */
        if(nums[mid]<target)
            return mid+1;
        else
            return mid;
    }

    public static void main(String[] args){
        int[] test = {11,34,67};
        System.out.print(new Search_Insert_Position().searchInsert(test,10));

    }
}
