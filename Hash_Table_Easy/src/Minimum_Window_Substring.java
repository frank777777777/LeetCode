/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        for(int i=0;i<t.length();i++){
            map[t_chars[i]]++;
        }
        int start=0,end=0,count_down=t.length(),length=Integer.MAX_VALUE,head=0;
        char temp;
        while(end<s.length()){
            temp=s_chars[end++];
            /* When the windows includes a char that is a member of t, decrease it in the map, and decrease
            * the count down */
            if(--map[temp]>=0){
                count_down--;
            }
            /* When count down is 0, we have included the substring in the window, now shrink the window */
            while(count_down==0){
                if(end-start<length)
                {
                    head=start;
                    length=end-start;
                }
                temp=s_chars[start++];
                if(++map[temp]>0){
                    count_down++;
                }
            }
        }
        return length==Integer.MAX_VALUE ? "" : s.substring(head,head+length);
    }
    public static void main(String[] args){
        String s="AD", t="ABC";
        System.out.print(new Minimum_Window_Substring().minWindow(s,t));
    }
}
