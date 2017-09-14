import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
/* Or we can build a map, to store each character appears how many times. The map size is 26 in this case.
* Or it can be 256 if it contans other ASCII characters */
public class Valid_Anagram {
    /* Sort and compare. Time complexity O(nlogn) */
    public boolean isAnagram(String s, String t) {
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        Arrays.sort(char_s);
        Arrays.sort(char_t);
        return Arrays.equals(char_s,char_t);
    }
    public static void main(String[] args){
        String s = "", t = "";
        System.out.print(new Valid_Anagram().isAnagram(s,t));
    }
}
