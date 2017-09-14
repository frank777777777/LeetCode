import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class Happy_Number {
    static final int[] map = new int[10];
    static{
        for(int i=0;i<=9;i++){
            map[i]=i*i;
        }
    }
    public boolean isHappy(int n) {
        /* The hashset is used to store what value has appeared before. If any, then it will be
        * stuck to a loop since this happened before */
        Set<Integer> set = new HashSet<>();
        set.add(n);
        /* Initialize new_num to a number that is different to n */
        int new_num =0;
        while(n!=1){
            /* For each digits, get its square values and sum up */
            while(n>0){
                int last_digit = n%10;
                n /= 10;
                new_num+=map[last_digit];
            }
            if(new_num==1)
                return true;
            /* if the hashset contains new num, then it is a infinite loop, we return false.
            * Else put it into the hashset */
            if(set.contains(new_num))
                return false;
            else
                set.add(new_num);
            n=new_num;
            new_num=0;
        }
        return true;
    }


    public static void main(String[] args){
        int num = 7;
        System.out.print(new Happy_Number().isHappy(num));
    }
}
