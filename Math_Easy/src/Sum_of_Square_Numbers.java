/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5
 Example 2:
 Input: 3
 Output: False*/
public class Sum_of_Square_Numbers {
    /*way too slow, since the squart() method I implemented myself was using software calculation, while
     * the native java implementation is using hardware */
//    public boolean judgeSquareSum(int c) {
//        if(c < 0){
//            return false;
//        }
//        int limit = square(c);
//        for(int i = 0; i <= limit; i++){
//            if(is_valid_square(c - i * i)){
//                return true;
//            }
//        }
//        return false;
//    }
//    private boolean is_valid_square(int n){
//        if(n < 0)
//            return false;
//        int square = square(n);
//        return square * square == n;
//    }
//    private int square(int n){
//        if(n < 0)
//            return -1;
//        long square = n;
//        while(square * square > n){
//            square = (square+n/square)/2;
//        }
//        return (int)square;
//    }

    /* much faster, beats 50%. But it can still be improved */
//    public boolean judgeSquareSum(int c) {
//        if(c < 0){
//            return false;
//        }
//        int limit = (int)Math.sqrt(c);
//        for(int i = 0; i <= limit; i++){
//            if(is_valid_square(c - i * i)){
//                return true;
//            }
//        }
//        return false;
//    }
//    private boolean is_valid_square(int n){
//        int square = (int)Math.sqrt(n);
//        return square * square == n;
//    }

    /* high is sqrt(c), therefore square(high+1) must be greater than c.
    * the low and high must be in between 0 and sqrt(c). Using the sliding windows to close down. If not found,
    * return false*/
    public boolean judgeSquareSum(int c) {
        if(c < 0){
            return false;
        }
        int high = (int)Math.sqrt(c);
        int low = 0;
        while(low <= high){
            if(low * low + high * high < c){
                low++;
            }else if(low * low + high * high > c){
                high--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new Sum_of_Square_Numbers().judgeSquareSum(3));
    }
}
