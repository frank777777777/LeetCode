/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])*/
public class Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += countHelper(i);
        }
        return sum;
    }

    public int countHelper(int n) {
        int count;
        if(n > 9) return 0;
        if(n == 1) return 10;

        count = factorial(n - 1, 9);

        return count * 9;
    }
    private int factorial(int rec, int n){
        if(rec == 1){
            return n;
        }

        return factorial(rec - 1, n - 1) * n;
    }

    public static void main(String[] args){
        System.out.print(new Count_Numbers_with_Unique_Digits().countNumbersWithUniqueDigits(3));
    }
}
