import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]*/
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(res, new ArrayList<>(), 0, s);
        return res;
    }
    private void partitionHelper(List<List<String>> res, List<String> list, int pos, String s){
        if(pos == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        int i = 1;
        String sub;
        /* pos is the position of separation between characters, so the max value is s.length() not s.length()-1*/
        while(pos + i <= s.length()){
            sub = s.substring(pos, pos + i);
            if(isPalindrome(sub)){
                list.add(sub);
                partitionHelper(res, list, pos + i, s);
                list.remove(list.size() - 1);
            }
            i++;
        }
    }
    private boolean isPalindrome(String str){
        int length = str.length();
        for(int i = 0; i < length; i++){
            if(str.charAt(i) != str.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        List<List<String>> lists = new Palindrome_Partitioning().partition(s);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }
}
