import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 Note:
 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int end=nums.length-1;
        /* We must pick the last element to get the maximum product. Then compare the first two and the last second the third, depending whichever is greater */
        return Math.max(nums[0]*nums[1],nums[end-1]*nums[end-2])*nums[end];
    }
    public static void main(String[] args){
        int[] test = {-4,-3,-2,-1,60};
        System.out.print(new Maximum_Product_of_Three_Numbers().maximumProduct(test));
    }
}
