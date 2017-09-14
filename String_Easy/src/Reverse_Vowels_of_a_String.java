/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */

/* important thoughts on this one, always check for the condition immediately everything the pointers changed! */
public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        /* initialization */
        char[] mychars = s.toCharArray();
        char temp;
        int i=0, j=mychars.length-1;
        /* check before looping ,i and j are pointers looking for vowels, is i is greater than j, then it already converged*/
        while(i<j){
            /* searching for the next vowel on both ends */
            for(; i<mychars.length; i++) {
                if(is_vowel(mychars[i])) break;
            }

            for(; j>-1; j--) {
                if(is_vowel(mychars[j])) break;
            }
            /* boundary condition, stop looping for it already converged*/
            if(i>=j)
                break;
            /* swap */
            temp = mychars[i];
            mychars[i]=mychars[j];
            mychars[j]=temp;
            /* move the pointers, so they can keep looking for the next vowel*/
            i++;
            j--;
        }
        return String.valueOf(mychars);
    }
    /* return true if it is vowel, else return false */
    public boolean is_vowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;

    }
    public static void main(String[] args){
        String test = "Unglad, I tar a tidal gnu.";
        System.out.print(new Reverse_Vowels_of_a_String().reverseVowels(test));
    }




}
