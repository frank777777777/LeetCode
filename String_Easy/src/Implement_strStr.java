/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

/* KMP algorithm with prefix table implementation, works better with huge haystack. However, it is a lot of overhead building the prefix table if the haystack is small */
public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        /* initialization */
        int length_haystack=haystack.length(), length_needle=needle.length();
        int[] prefix_table = get_prefix_table(needle);
        int i=0, j=0;
        /* two pointers */
        while(i<length_haystack && j<length_needle){
            /* if matches, move both pointers and try match the next two */
            if(j<needle.length() && haystack.charAt(i)==needle.charAt(j)){
                i++; j++;
            }
            /* if j is not at the beginning, try the next longest prefix-suffix sequence */
            else if (j!=0){
                j=prefix_table[j-1];
            }
            /* if j is at the beginning, try the next i */
            else
                i++;
        }
        /* the loop can be terminated by either i or j reaches the end. When j equals length_needle,
        * in which case the needle is matched, return the position, otherwise i reaches the end, the needle
         * is not found */
        if(j==length_needle)
            return i-length_needle;
        else
            return -1;
    }

    /* getting the prefix table, where each value is the index that it can go back so that the prefix equals to the suffix */
    public int[] get_prefix_table(String str){
        int length = str.length();
        int[] prefix_table = new int[str.length()];
        int i=0, j=1;
        while(i<length && j<length){
            /* move both pointers when matches */
            if(str.charAt(i)==str.charAt(j)){
                prefix_table[j]=i+1;
                j++; i++;
            }
            else{
                if(i==0){
                    prefix_table[j]=0;  /* move along the j pointer and try to find the next prefix-suffix sequence */
                    j++;
                }
                else{
                    i=prefix_table[i-1];    /* go back to the second longest prefix-suffix sequence */
                }
            }
        }
        return prefix_table;
    }

    public static void main(String[] args){
        String haystack = "mississippi", needle = "issip";

        System.out.print(new Implement_strStr().strStr(haystack, needle));
    }


}
