/**
 *Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class Reverse_Words_In_A_String {
    //Reverse the whole string
    public static String reverseString(String s) {
        String newString;
        char temp;
        char [] myChars = s.toCharArray();
        int length = myChars.length;
        for(int i=0; i<length/2;i++){
            temp = myChars[i];
            myChars[i]=myChars[length-1-i];
            myChars[length-1-i]=temp;
        }
        newString = String.valueOf(myChars);
        return newString;
    }
    //split the String by delimiter " ", and then pass it to reverse string
    public static String reverseWords(String s){
        String newString="";
        String [] segments = s.split(" ");
        for(int i=0; i<segments.length; i++){
            segments[i]=reverseString(segments[i]);
            newString = newString.concat(segments[i]);
            if(i!=segments.length-1){
                newString = newString.concat(" ");
            }
        }
        return newString;
    }

    public static void main(String[] args) {
        String test = "This is test";
        String new_test = reverseWords(test);
        System.out.print(new_test);

    }
}
