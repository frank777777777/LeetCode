import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Find_All_Anagrams_in_a_String {
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new LinkedList<>();
//        if(p.length()>s.length())
//            return list;
//        /* mapping the char to to its count in String p */
//        int[] map_p = new int[256];
//        for(int i=0;i<p.length();i++){
//            map_p[p.charAt(i)]++;
//        }
//        /* check every segments, and compare the counts of every char, if they are same, add the index to
//        * the list */
//        for(int i=0;i<=s.length()-p.length();i++){
//            boolean flag=true;
//            int[] map_s = new int[256];
//            for(int j=0;j<p.length();j++){
//                map_s[s.charAt(i+j)]++;
//            }
//            for(int k=0;k<p.length();k++){
//                if(map_s[p.charAt(k)]!=map_p[p.charAt(k)])
//                    flag=false;
//            }
//            if(flag==true)
//                list.add(i);
//        }
//        return list;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if(s==null || p==null || s.length()==0 || p.length()==0 || p.length()>s.length())
            return list;
        int[] map = new int[256];
        for(int i=0;i<p.length();i++){
            map[p.charAt(i)]++;
        }
        int start=0,end=0,diff=p.length();
        char temp;
        while(end<s.length()){
            temp=s.charAt(end++);
            if(--map[temp]>=0)
                diff--;
            if(diff==0)
                list.add(start);
            if(end-start==p.length()){
                temp=s.charAt(start++);
                if(++map[temp]>0)
                    diff++;
            }
        }
        return list;
    }

    public static void main(String[] args){
        String s="cbad",p="ab";
        List<Integer> result = new Find_All_Anagrams_in_a_String().findAnagrams(s,p);
        for(int index:result)
            System.out.print(index+" ");
    }
}
