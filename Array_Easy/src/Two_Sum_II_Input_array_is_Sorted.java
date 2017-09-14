/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Two_Sum_II_Input_array_is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        /* Because it is guaranteed to have a solution, so the start and end can converge until finding an answer */
        int start=0, end=numbers.length-1;
        while(start<end){
            if (numbers[start] + numbers[end]==target)
                return new int[]{start+1,end+1};
            else if(numbers[start] + numbers[end]>target)
                end--;
            else
                start++;
            }
        return new int[]{0,0};
    }
    public static void main(String[] args){
        int[] test = {2,3,4};
        for(int i:new Two_Sum_II_Input_array_is_Sorted().twoSum(test,6))
            System.out.print(i+"\n");
    }


    /* Binary search, faster yet harder to implement */
//    public int[] twoSum(int[] numbers, int target) {
//        if (numbers == null || numbers.length == 0) {
//            return new int[2];
//        }
//        int start = 0;
//        int end = numbers.length - 1;
//        while (start < end) {
//            if (numbers[start] + numbers[end] == target) {
//                return new int[]{start + 1, end + 1};
//            } else if (numbers[start] + numbers[end] > target) {
//                // move end forward to the last value that numbers[end] <= target - numbers[start]
//                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
//            } else {
//                // move start backword to the first value that numbers[start] >= target - numbers[end]
//                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
//            }
//        }
//        return new int[2];
//    }
//    private int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
//        int left = start;
//        int right = end;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (numbers[mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right;
//    }
//    private int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
//        int left = start;
//        int right = end;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (numbers[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return left;
//    }

}
