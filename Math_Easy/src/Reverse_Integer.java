/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.*/
public class Reverse_Integer {
    public int reverse(int x) {
        int reversed = 0;
        while(x != 0){
            if(reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE /10) return 0; /* avoid overflow */
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }

    public static void main(String[] args){
        System.out.println(new Reverse_Integer().reverse(-2147483641));

    }
}
