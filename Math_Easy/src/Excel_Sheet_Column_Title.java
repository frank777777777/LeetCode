/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB */
public class Excel_Sheet_Column_Title {
//    private static final char[] map = new char[27];
//    static {
//        for(int i = 1; i <= 26; i++){
//            map[i] = (char) ('A' -1 + i);
//        }
//    }
//    public String convertToTitle(int n) {
//        StringBuilder sb = new StringBuilder();
//        int charDigit;
//        while(n > 0){
//            charDigit = n % 26;
//            if(charDigit == 0){
//                sb.insert(0,'Z');
//                n -= 26;
//            }else {
//                sb.insert(0,map[charDigit]);
//            }
//            n /= 26;
//        }
//        return sb.toString();
//    }

    public String convertToTitle(int n) {
        String re = "";
        while(n>0){
            re = (char)(( (n-1) %26)+'A') + re;
            n = (n-1)/26;
        }
        return re;
    }

    public static void main(String[] args){
//        System.out.println(map[1]);
//        System.out.println((char)('A'+26));
        System.out.println(new Excel_Sheet_Column_Title().convertToTitle(28));
    }
}
