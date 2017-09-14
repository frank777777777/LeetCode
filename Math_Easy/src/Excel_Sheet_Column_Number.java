/**
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28 */
public class Excel_Sheet_Column_Number {
    static final int[] map = new int[256];
    static {
        for(char c = 'A'; c <= 'Z'; c++){
            map[c] = c - 'A' + 1;
        }
    }
    public int titleToNumber(String s) {
        if(s.isEmpty())
            return 0;
        int number = 0;
        int power = 1;
        /* from right to left, power grows by 26 each iteration */
        for(int i = s.length()-1; i >= 0; i--){
            number += map[s.charAt(i)] * power;
            power *= 26;
        }
        return number;
    }

    //better solution
//    public int titleToNumber(String s) {
//        int result = 0;
//        for(int i = 0; i < s.length(); i++){
//            result = result*26 + (s.charAt(i) - 'A' + 1);
//        }
//        return result;
//    }

    public static void main(String[] args){
        String s = "AB";
        System.out.println(new Excel_Sheet_Column_Number().titleToNumber(s));
    }
}
