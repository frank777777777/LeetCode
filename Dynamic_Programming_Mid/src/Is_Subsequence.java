/**
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 Follow up:
 If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?*/
public class Is_Subsequence {
    /* two pointers, and compare */
    /* charArray access is faster than String.charAt() */
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length()){
            return false;
        }
        char[] sArrs = s.toCharArray();
        char[] tArrs = t.toCharArray();
        if(sArrs.length == 0){
            return true;
        }
        if(sArrs.length == tArrs.length){
            return s.equals(t);
        }
        int m = 0, n = 0;
        while(n < t.length()){
            if(sArrs[m] == tArrs[n]){
                m++;
                n++;
                if(m == sArrs.length){
                    return true;
                }
            }else {
                n++;
            }

        }
        return false;
    }
    public static void main(String[] args){
        String s = "bdc", t = "uuubdc";
        System.out.print(new Is_Subsequence().isSubsequence(s, t));
    }
}
