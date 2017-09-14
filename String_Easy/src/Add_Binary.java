/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        int len_a=a.length(), len_b=b.length();
        int pointer=0;
        int carry=0, remainder;
        StringBuilder result = new StringBuilder("");

        /* Pointer move from the very right to the very left, after the dominance bit, set it all to 0 */
        while(pointer<len_a || pointer<len_b || carry!=0){
            /* set it to 1 or 0 */
            int x = (pointer<len_a) ? (a.charAt(len_a-1-pointer)=='1' ? 1:0) : 0;
            int y = (pointer<len_b) ? (b.charAt(len_b-1-pointer)=='1' ? 1:0) : 0;


//            int x = (pointer<len_a) ? Character.getNumericValue(a.charAt(len_a-1-pointer)) : 0;
//            int y = (pointer<len_b) ? Character.getNumericValue(b.charAt(len_b-1-pointer)) : 0;
            remainder = (x+y+carry)%2;
            result.insert(0,remainder);
            carry = (x+y+carry)/2;
            pointer++;
        }
        return String.valueOf(result);

    }
    public static void main(String[] args){
        String test1 = "11", test2 = "1";



        System.out.print(new Add_Binary().addBinary(test1, test2));
    }
}
