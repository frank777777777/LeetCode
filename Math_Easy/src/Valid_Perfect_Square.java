/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False*/
public class Valid_Perfect_Square {
//    public boolean isPerfectSquare(int num) {
//        int sqr = mySqrt(num);
//        return num == sqr * sqr;
//    }
//    /* no need to round up. base case, check the high and low, and return the low*/
//    private int mySqrt(int x) {
//        if (x == 1 || x == 0) {
//            return x;
//        }
//        int low = 0;
//        int high = x;
//        while (low + 1 < high) {
//            int mid = low + (high - low) / 2;
//            if (mid == x / mid) {
//                low = mid;
//            } else if (mid > x / mid) {
//                high = mid;
//            } else {
//                low = mid;
//            }
//        }
//        if (high > x / high) {
//            return low;
//        } else {
//            return high;
//        }
//    }

    /* Newton's method ,see calculus */
    public boolean isPerfectSquare(int x){
        long r = x;
        while (r * r > x){
            r = (r + x/r)/2;
        }

        return r * r == x;
    }
    public static void main(String[] args){
        System.out.println(new Valid_Perfect_Square().isPerfectSquare(2));
    }
}
