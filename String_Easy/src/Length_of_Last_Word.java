/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int counter=0;
        boolean start=false;
        int i=s.length()-1;
        /* When it encounters the first non empty char, set start to true, and start counting. Stop counting when either finishes looping or encounters another space */
        while(i>=0){
            if(s.charAt(i) ==' ' && start ==true)
                break;
            else if(s.charAt(i)!=' '){
                counter++;
                start=true;
            }
            i--;
        }
        return counter;
    }
    public static void main(String[] args){
        String test = "";
        System.out.print(new Length_of_Last_Word().lengthOfLastWord(test));
    }
}
