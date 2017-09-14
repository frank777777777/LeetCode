/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        /* prepare data, char array is faster than subString*/
        char[] mychar = s.toCharArray();
        /* pick a number, that is a divider of the length, because it has to be evenly divided */
        for(int i=2; i<=mychar.length; i++){
            /* check answer when the String can be evenly divided*/
            if(mychar.length%i == 0 && check(mychar, i)==true)
                return true;
        }
        return false;

    }

    /* Check if the array can be identically divided into num_partitions */
    public boolean check(char[] mychar, int num_partitions){
        int partition_length = mychar.length/num_partitions;

        /* loop within one partitions */
        for(int i=0; i<partition_length; i++){

            /* compare the char with the same position in other partitions */
            for(int j=1; j<=num_partitions-1; j++){
                if(mychar[i]!=mychar[i+j*partition_length])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String test = "aabcaa";
//        System.out.print(test.substring(3,7));

        System.out.print(new Repeated_Substring_Pattern().repeatedSubstringPattern(test));
    }


    /* Use hashcode to test the string first, */

//    public boolean repeatedSubstringPattern(String s) {
//        for(int i=2; i<=s.length(); i++){
//            if(s.length()%i == 0 && check(s, i)==true)
//                return true;
//        }
//        return false;
//
//    }
//    public boolean check(String s, int num_partitions){
//        int partition_length= s.length()/num_partitions;
//        for(int i=1; i<=num_partitions-1; i++){
//            String sub1=s.substring(0,partition_length);
//            String sub2=s.substring(i*partition_length,(i+1)*partition_length);
//            if(sub1.hashCode()!=sub2.hashCode())
//                return false;
//        }
//        for(int i=0; i<partition_length; i++){
//            for(int j=1; j<=num_partitions-1; j++){
//                if(s.charAt(i)!=s.charAt(i+j*partition_length))
//                    return false;
//            }
//        }
//        return true;

//    }




}
