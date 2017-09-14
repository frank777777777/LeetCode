/**
 *Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class Reverse_String {
    public String reverseString(String s) {
        char[] myChar = s.toCharArray();
        char temp;
        int length = s.length();
        for(int i=0; i<length/2; i++){
            temp = myChar[i];
            myChar[i] = myChar[length-1-i];
            myChar[length-1-i] = temp;
        }
        String newString = String.valueOf(myChar);
        return newString;
    }
}
