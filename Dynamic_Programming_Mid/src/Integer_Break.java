/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.*/
public class Integer_Break {
    /* stores the intermediate value of the recursion. index is n, value is the max it it can get */
    int[] dp;
    public int integerBreak(int n) {
        int max = 0;
        dp = new int[n + 1];
        for(int i = 1; i <= n/2; i++){
            max = Math.max(max, helper(i) * helper(n - i));
        }
        return max;
    }
    /* return the max value it can get out of n. Either n(no splitting), or max of split 1 * split 2 */
    private int helper(int n){
        if(n == 1){
            dp[1] = 1;
            return 1;
        }
        int max = n;
        int value1, value2;
        for(int i = 1; i <= n/2; i++){
            /* if the dp is 0, means we need to calculate it, otherwise just retrieve the value. dp[i] is the max it can get out of i */
            value1 = dp[i] == 0 ? helper(i) : dp[i];
            value2 = dp[n - i] == 0 ? helper(n - i) : dp[n - i];
            max = Math.max(max, value1 * value2);
        }
        dp[n] = max;
        return max;
    }

    public static void main(String[] args){
        System.out.println(new Integer_Break().integerBreak(2));
    }
}
