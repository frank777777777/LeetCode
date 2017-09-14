import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class Isomorphic_Strings {
    /* working ,but not very fast ,O(n)*/
//    public boolean isIsomorphic(String s, String t) {
//        int length = s.length();
//        HashMap<Character,Character> map = new HashMap<>();
//        HashSet<Character> set = new HashSet<>();
//        for(int i=0;i<length;i++){
//            /* a value cannot be hashed twice */
//            if(!map.containsKey(s.charAt(i)) && !set.contains(t.charAt(i))){
//                map.put(s.charAt(i),t.charAt(i));
//                set.add(t.charAt(i));
//                i--;
//            } else if(map.getOrDefault(s.charAt(i),s.charAt(i))!=t.charAt(i)){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t){
        /* map char to a number, initially all 0 */
        int[] map_s = new int[256];
        int[] map_t = new int[256];
        /* map chars in s ant t to another value if they are not mapped yet, when the value is 0.
        * If they are mapped or one of them is mapped, the values won't be the same, return false */
        for(int i=0;i<s.length();i++){
            if(map_s[s.charAt(i)]!=map_t[t.charAt(i)])
                return false;
            map_s[s.charAt(i)]=i+1;
            map_t[t.charAt(i)]=i+1;
        }
        return true;
    }
    public static void main(String[] args){
        String s="aa", t="aa";
        System.out.print(new Isomorphic_Strings().isIsomorphic(s,t));
    }
}
