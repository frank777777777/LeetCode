/**
 * Determine whether an integer is a palindrome. Do this without extra space.

 click to show spoilers.

 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.*/
public class Palindrome_Number {
    /* reverse the number, and compare with the original */
    public boolean isPalindrome(int x) {
        /* negative numbers are not palindrome numbers */
        if(x < 0)
            return false;
        int reversed = 0;
        int temp = x;
        while(temp > 0){
            reversed *= 10;
            reversed += temp % 10;
            temp /= 10;
        }
        return x == reversed;
    }
    public static void main(String[] args){
        System.out.println(new Palindrome_Number().isPalindrome(2147447412));
    }
}
