/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?*/
public class Add_Digits {
//    public int addDigits(int num) {
//        /* loop until it is single digits */
//        while(num > 9){
//            /* loop and sum all digits */
//            int temp = 0;
//            while(num > 0){
//                temp += num % 10;
//                num /= 10;
//            }
//            num = temp;
//        }
//        return num;
//    }

    /* digit root problem can be solved with Congruence forluma, where dr(r) = 1 + (r - 1) mod 9. or num==0?0:(num%9==0?9:(num%9))*/
    public int addDigits(int num){
        return 1 + (num -1) % 9;
    }
    public static  void main(String[] args){
        System.out.println(new Add_Digits().addDigits(18));

    }
}
