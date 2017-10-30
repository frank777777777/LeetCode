/**
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

 Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 Paste: You can paste the characters which are copied last time.
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

 Example 1:
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.
 Note:
 The n will be in the range [1, 1000].*/
public class Two_Keys_Keybard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        /* we are trying to find j, where we can divide n into j piece, and we need i/j steps from dp[j], since we need 1 to copy,
        * and i/j - 1 to paste. We try to minimize i/j, so we maximize j, which is at mose i/2, so we start j from i/2. j is minimum 1, so
        * we need n steps at most. It is intuitively to know that the larger j can get lesser dp[j] + i/j. So we do not try test other smaller j within
        * the same i loop. */
        for(int i = 1; i <= n; i++){
            for(int j = i / 2; j >= 1; j--){
                if(i % j == 0){
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.print(new Two_Keys_Keybard().minSteps(14));
    }
}
