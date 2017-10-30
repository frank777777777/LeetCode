import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
//////////////
 A graph of phone numbers, each has 3 letters and * and #
 /////////


 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/
public class Letter_Combinations_of_a_Phone_Number {
    static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int[] digitsArray = new int[digits.length()];
        /* convert the digits String to an array of integers */
        for(int i = 0; i < digitsArray.length; i++){
            digitsArray[i] = Character.getNumericValue(digits.charAt(i));
            if(digitsArray[i] < 2){
            }
        }
        List<String> res = new LinkedList<>();
        helper(digitsArray, 0 , res, new ArrayList<>());
        return res;
    }
    private void helper(int[] digitsArray, int pos, List<String> res, ArrayList<Character> chars){
        if(pos == digitsArray.length){
            if(chars.size() == 0) return;
            StringBuilder temp = new StringBuilder();
            for(Character c : chars){
                temp.append(c);
            }
            res.add(temp.toString());
            return;
        }
        /* get the String in respect to the phone key number */
        String mapString = map[digitsArray[pos]];
        for(int i = 0; i < mapString.length(); i++){
            chars.add(mapString.charAt(i));
            helper(digitsArray, pos + 1, res, chars);
            chars.remove(chars.size() - 1);
        }
    }

    public static void main(String[] args){
        String input = "0";
        List<String> list = new Letter_Combinations_of_a_Phone_Number().letterCombinations(input);
        for(String st : list){
            System.out.println(st);
        }
    }
}
