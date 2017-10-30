/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".*/
public class Longest_Palindromic_Subsequence {
    // Working implementation, but uses 2-D array
//    public int longestPalindromeSubseq(String s) {
//        char[] chararr = s.toCharArray();
//        /* 2-D array, as dp[i][j] stores longest length from i to j*/
//        int[][] dp = new int[chararr.length][chararr.length];
//        for(int i = chararr.length; i >= 0; i--){
//            for(int j = i; j < chararr.length; j++){
//                if(i == j){ dp[i][j] = 1; } // a single char is a palindrome of max length 1
//                else if(chararr[i] == chararr[j]){
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                }else {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[0][chararr.length - 1];
//    }

    /* It can be observed that it only need this row and previous row. So a 1-D array dp is sufficient */
    public int longestPalindromeSubseq(String s) {
        char[] chararr = s.toCharArray();
        /* initiate an array with all zeros */
        int[][] dp = new int[2][chararr.length];
        /* bi makes index alternating between 0 and 1, because we only need the current row and previous row */
        int index = 0;
        for(int i = chararr.length - 1, bi = 0; i >= 0; i--, bi++){
            index = bi & 1; /* alternating between 0 and 1*/
            for(int j = i; j < chararr.length; j++){
                /* index is the current row, i - index is the other row */
                if(i == j){ dp[index][j] = 1; }
                else if(chararr[i] == chararr[j]){
                    dp[index][j] = dp[1 - index][j - 1] + 2;
                }else {
                    dp[index][j] = Math.max(dp[1 - index][j], dp[index][j - 1]);
                }
            }
        }
        return dp[index][chararr.length - 1];
    }
    public static void main(String[] args){
        String s = "cbbd";
        System.out.print(new Longest_Palindromic_Subsequence().longestPalindromeSubseq(s));
    }
}
