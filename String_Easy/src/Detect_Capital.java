/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False
 Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Detect_Capital {
    public boolean detectCapitalUse(String word) {
        boolean flag = false;
        /* if they are all lower case or upper case*/
        if(word == word.toLowerCase() || word == word.toUpperCase())
            flag = true;

        /* cut the string into to parts, the first char and the remaining, and test them separately */
        if(word.length()>1){
            StringBuilder temp1 = new StringBuilder(word);
            StringBuilder temp2 = new StringBuilder(word);
            String StrTemp1 = temp1.delete(1,temp1.length()).toString();
            String StrTemp2 = temp2.deleteCharAt(0).toString();
            if(StrTemp2 == StrTemp2.toLowerCase() && StrTemp1 == StrTemp1.toUpperCase())
                flag = true;
        }

        return flag;
    }
    public static void main(String[] args){
        String test = "Leetcode";
        System.out.print(new Detect_Capital().detectCapitalUse(test));
    }
}
