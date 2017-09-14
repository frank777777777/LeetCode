import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Longest_Palindrome {
    public int longestPalindrome(String s) {
        int length=s.length();
        int count=0;
        if(length==0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        /* count number of pairs, remove the pair if we found a pair */
        for(int i=0;i<length;i++){
            if(!set.add(s.charAt(i))){
                count+=2;
                set.remove(s.charAt(i));
            }
        }
        /* if count is length, meanings its symmetric, return count, otherwise we put place any thing in the
        * middle to make it a palindrome */
        return length!=count ? count+1 : count;
    }
    public static void main(String[] args){
        String s = "abccccdd";
        System.out.print(new Longest_Palindrome().longestPalindrome(s));
    }
}
