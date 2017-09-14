/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.*/
public class Factorial_Trailing_Zeroes {
    /* count the number of fives and twos, each pair forms a trailing zero
    * this codes takes n^2 time, exceeds the logarithmic time complexity */
//    public int trailingZeroes(int n) {
//        int fives = 0;
//        int twos = 0;
//        for(int i = 1; i <= n; i++){
//            int temp = i;
//            while(1 == 1){
//                if(temp % 5 == 0){
//                    temp /= 5;
//                    fives++;
//                }else if(temp % 2 ==0){
//                    temp /= 2;
//                    twos++;
//                }else {
//                    break;
//                }
//            }
//        }
//        return Math.min(fives,twos);
//    }

    /* We need to calculate the number of fives and twos, since twos are always more than fives,
    * we just need to calculate fives. And since there are 25, 125 and etc, we treat 25 as two fives,
    * and 125 as three fives, so we adding n/5 + n/25 + n/125 + n/625 + n/3125+...;*/
    public int trailingZeroes(int n) {
        // Initialize result
        int count = 0;
        // Keep dividing n by powers of 5 and update count
        for (long i=5; i <= n; i *= 5)
            count += n/i;
        return count;
    }

    public static void main(String[] args){
        System.out.println(new Factorial_Trailing_Zeroes().trailingZeroes(Integer.MAX_VALUE));

    }
}
