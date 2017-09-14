/**
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?*/
public class Power_of_Three {
    /* naive searching, listing all the power of three and compare. */
//    public boolean isPowerOfThree(int n) {
//        if(n != 1 && n % 3 != 0)
//            return false;
//        int power = 1;
//        /* when power is negative, means int overflow. Therefore return false */
//        while(power <= n && power > 0){
//            if(power == n)
//                return true;
//            power *= 3;
//        }
//        return false;
//    }

    /* yet another naive search */
    public boolean isPowerOfThree(int n){
        if(n < 1)
            return false;
        if(n == 1)
            return true;
        while(n>1){
            if(n % 3 != 0)
                return false;
            n /= 3;
        }
        return true;
    }

    /* without recursion. But we have to calculate 3^19 first */
//    public boolean isPowerOfThree(int n) {
//        // 1162261467 is 3^19,  3^20 is bigger than int
//        return ( n>0 &&  1162261467%n==0);
//    }
    public static void main(String[] args){
        System.out.println(new Power_of_Three().isPowerOfThree(1162261467));
    }
}
