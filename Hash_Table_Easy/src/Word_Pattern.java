import java.util.HashMap;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] segments = str.split(" ");
        if(pattern.length()!=segments.length)
            return false;
        /* hashmap maps every segments Strings, and char_map maps chars */
        HashMap<String,Integer> segments_map = new HashMap<>();
        int[] char_map = new int[128];
        for(int i=0;i<pattern.length();i++){
            /* return false if they maps to different value, since their initial value will be 0, means they
            * cannot be re-mapped */
            if(char_map[pattern.charAt(i)]!=segments_map.getOrDefault(segments[i],0))
                return false;
            char_map[pattern.charAt(i)]=i+1;
            segments_map.put(segments[i],i+1);
        }
        return true;
    }
    public static void main(String[] args){
        String pattern = "abbc";
        String str = "dog cat cat dog";
        System.out.print(new Word_Pattern().wordPattern(pattern,str));
    }
}
