/**
 * Given an integer, write a function to determine if it is a power of two.*/
public class Power_of_Two {
//    public boolean isPowerOfTwo(int n){
//        if(n < 1)
//            return false;
//        if(n == 1)
//            return true;
//        int power = 1;
//        for(int i = 0; i < 30; i++){
//            power <<= 1;
//            if(n == power)
//                return true;
//        }
//        return false;
//    }

    /* bit operation. since there is only one bit 1 in the integer. It AND (n-1) should be 0*/
    public boolean isPowerOfTwo(int n){
        return ((n & (n-1))==0 && n>0);
    }
    public static void main(String[] args){
        System.out.println(new Power_of_Two().isPowerOfTwo(1073741824));
    }
}
