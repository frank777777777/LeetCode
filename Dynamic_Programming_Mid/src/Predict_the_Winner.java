/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

 Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

 Example 1:
 Input: [1, 5, 2]
 Output: False
 Explanation: Initially, player 1 can choose between 1 and 2.
 If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 Hence, player 1 will never be the winner and you need to return False.
 Example 2:
 Input: [1, 5, 233, 7]
 Output: True
 Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 Note:
 1 <= length of the array <= 20.
 Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 If the scores of both players are equal, then player 1 is still the winner.*/
public class Predict_the_Winner {
    /* dp solution */
    /* Working implementation, but the space complexity is O(n^2).*/
//    public boolean PredictTheWinner(int[] nums) {
//        if(nums == null) { return true; }
//        if ((nums.length & 1) == 0) { return true; }
//        /* create dp table, and initialize the orthogonal to num[i]
//         * dp[i][j] represents the maximum score that the current player can outscore the other.
//          * So if the current player take num[i], he can out score the other player num[i] - dp[i+1][j],
//          * if hte take num[j], he can outscore the other player num[j] - dp[i][j-1]. And dp[i][j] is the max among these two */
//        int[][] dp = new int[nums.length][nums.length];
//        for(int i = 0; i < nums.length; i++){ dp[i][i] = nums[i]; }
//        /* draw the table, and you can see how the table can be filled */
//        for(int j = 1; j < nums.length; j++){
//            for(int i = j - 1; i >= 0; i--){
//                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//            }
//        }
//        return dp[0][nums.length - 1] >= 0;
//    }

    /* Space complexity O(n) implementation, actually we do not need previous rows, when we update, we can set dp[i][i] = num[i],
    * and we only care about previous column. Just draw the table, and see how the table is filled, we can reduce it to O(n) space complexity  */
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null) { return true; }
        /* if it has even number of elements, player 1 always win. Since when he pick the first value first, he will always pick
        * odd index, if he pick the last value, he will always pick the even index. He can just calculate the sum of odd and even
        * indexes to decide pick the first or last elements */
        if ((nums.length & 1) == 0) { return true; }
        int[] dp = new int[nums.length];
        for(int j = 0; j < nums.length; j++){
            for(int i = j; i >=0; i--){
                /* orthogonal just be nums[i] */
                if(i == j){ dp[i] = nums[i]; }
                else {
                    dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
                }

            }
        }
        return dp[0] >= 0;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3, 2, 1, 4, 1};
        System.out.println(new Predict_the_Winner().PredictTheWinner(nums));
    }
}
