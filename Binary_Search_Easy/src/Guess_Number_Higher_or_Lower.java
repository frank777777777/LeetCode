/**
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.*/
public class Guess_Number_Higher_or_Lower {
    private int guess(int n){
        int theNumber = 1;
        if(n < theNumber)
            return 1;
        else if(n > theNumber)
            return -1;
        else
            return 0;
    }
    public int guessNumber(int n) {
        int low = 1, high = n;
        int mid;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(guess(mid) < 0){
                high = mid;
            }else if(guess(mid) > 0){
                low = mid + 1;
            }else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(new Guess_Number_Higher_or_Lower().guessNumber(10));
    }
}
