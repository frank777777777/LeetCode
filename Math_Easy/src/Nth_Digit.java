/**
 * Nth Digit
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 Example 1:

 Input:
 3

 Output:
 3
 Example 2:

 Input:
 11

 Output:
 0

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.*/
public class Nth_Digit {
    public int findNthDigit(int n) {
        int digit_length = 1;
        long count = 9; /* number of numbers in this portion, use long since this number might overflow */
        int start = 1; /* the starting number of this portion */

        while(n > count * digit_length){
            n -= count * digit_length;
            count *= 10;
            digit_length++;
            start *= 10;

        }
        /* calculate the actual number of the digit we are looking for */
        int Number = start + (n - 1) / digit_length;
        String NumberSt = String.valueOf(Number);

        return Character.getNumericValue(NumberSt.charAt((n - 1) % digit_length));

    }

    public static void main(String[] args){
        System.out.println(new Nth_Digit().findNthDigit(2147483647));
    }
}
