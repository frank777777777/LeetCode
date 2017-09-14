/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14
 Note: The input number n will not exceed 100,000,000. (1e8)*/
public class Perfect_Number {
    /** naive search, linear time, exceeding time complexity */
//    public boolean checkPerfectNumber(int num) {
//        int sum = 0;
//        for(int i = 1; i < num; i++){
//            if(num % i == 0){
//                sum += i;
//            }
//        }
//        return sum == num;
//    }

    /* only check until x, and for each found x as divisor, num/x is also a divisor, so only scan
    * through square(num) nums. Remember to plus 1 in the end, since we start from 2, and we should include 1 as well */
    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int sum = 0;
        for(int x = 2; x * x <= num; x++){
            if(num % x == 0){
                sum += x;
                if(x * x != num){
                    sum += num / x;
                }
            }
        }
        sum++;
        return sum == num;
    }

    public static void main(String[] args){
        System.out.println(new Perfect_Number().checkPerfectNumber(1));
    }
}
