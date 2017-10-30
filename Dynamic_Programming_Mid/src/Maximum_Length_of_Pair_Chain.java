import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

 Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

 Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

 Example 1:
 Input: [[1,2], [2,3], [3,4]]
 Output: 2
 Explanation: The longest chain is [1,2] -> [3,4]
 Note:
 The number of given pairs will be in the range [1, 1000].*/
public class Maximum_Length_of_Pair_Chain {
    /* greedy algorithm */
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0 || pairs == null){
            return 0;
        }
       Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        /* the first pair is always included in the longest chain */
       int sum = 1, i = 1, current = pairs[0][1];
       while(i < pairs.length){
           if(pairs[i][0] > current){
               sum++;
               current = pairs[i][1];
           }
           i++;
       }
       return sum;
    }
    public static void main(String[] args){
        int[][] pairs = new int[][]{{1,2}, {3,4}, {2,3}};
        System.out.println(new Maximum_Length_of_Pair_Chain().findLongestChain(pairs));
    }
}
