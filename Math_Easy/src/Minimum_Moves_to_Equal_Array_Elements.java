/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Minimum_Moves_to_Equal_Array_Elements {
    /* incrementing n-1 elements, is the same as decrementing 1 elements. The steps it takes, is how many decrement
     * should be operated. We try to find the minimum value across the array, and for each value minus the min, is the
      * steps that it should take */
    public int minMoves(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = min < i ? min : i;
        }

        int steps = 0;
        for(int i : nums){
            steps += i - min;
        }
        return steps;
    }
}
