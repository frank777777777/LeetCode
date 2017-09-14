import java.util.Arrays;

/**
 * Created by Frank on 7/8/2017.
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        if(strs.length==0)
            return "";
        StringBuilder LongestCommonPrefix = new StringBuilder("");
        /* find boundary */
        int shortest_length = Integer.MAX_VALUE;
        for(String str: strs){
            if(shortest_length>str.length())
                shortest_length = str.length();
        }
        /* compare each char across the array of Strings, append if matches */
        for(int i=0; i<shortest_length; i++){
            for(int j=0; j<strs.length; j++){
                /* compare each position across the String array with the first String, if not matches, return */
                if(strs[0].charAt(i)!=strs[j].charAt(i))
                    return LongestCommonPrefix.toString();
            }
            LongestCommonPrefix.append(strs[0].charAt(i));
        }
        return LongestCommonPrefix.toString();
    }
    public static void main(String[] args){
        String[] test = {};
        System.out.print(new Longest_Common_Prefix().longestCommonPrefix(test));
    }
}
