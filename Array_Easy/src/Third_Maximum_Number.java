/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */
public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        /* max1 is the largest, max2 is the second largest, max3 is the third maximum */
        Integer max1=null,max2=null,max3=null;
        for(Integer value: nums){
            /* skip any duplicate numbers that has already in max1,2,3 */
            if(value.equals(max1) || value.equals(max2) || value.equals(max3))
                continue;
            /* if max1 has no value, or it is greater than original max1, it is the largest */
            if(max1==null || value>max1){
                max3=max2;
                max2=max1;
                max1=value;
            }
            /* Replace the value to max2, if it is less than max1 and greater than max2 */
            else if(max2==null || value>max2){
                max3=max2;
                max2=value;
            }
            /* Replace the value to max3, if it is less than max1 and max2 yet greater than max3  */
            else if(max3==null || value>max3)
                max3=value;
        }
        return max3==null ? max1 : max3;
    }
    public static void main(String[] args){
        int[] nums = {2,2,3,1};
        System.out.print(new Third_Maximum_Number().thirdMax(nums));
    }
}
