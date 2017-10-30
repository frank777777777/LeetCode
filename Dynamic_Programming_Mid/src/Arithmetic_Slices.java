/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.

 */
public class Arithmetic_Slices {
    /* Working implementation, brute force, expanding method */
//    int count = 0;
//    public int numberOfArithmeticSlices(int[] A) {
//        if(A.length < 3) return 0;
//        for(int i = 0; i < A.length; i++){
//            countArithmetic(A, i, i);
//            countArithmetic(A, i, i + 1);
//        }
//        return count;
//
//    }
//    private void countArithmetic(int[] A, int i, int j){
//        if(i <= 0 || j >= A.length - 1)
//            return;
//        int difference;
//        /* if the center is a single value */
//        if(i == j){
//            difference = A[i] - A[i - 1];
//            if(difference != A[i + 1] - A[i]){
//                return;
//            }
//        }else { /* if the center is two values */
//            difference = A[j] - A[i];
//            if(A[i] - A[i - 1] != difference || A[j + 1] - A[j] !=difference){
//                return;
//            }
//        }
//        /* expand and count the number of slices */
//        while(i - 1 >= 0 && j + 1 < A.length && A[i] - A[i - 1] == difference && A[j + 1] - A[j] == difference){
//            count++;
//            i--;
//            j++;
//        }
//    }

    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, current = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i - 1] - A[i - 2] == A[i] - A[i - 1]){
                /* for every addition value that satisfies, it has 1 more count than the previous.*/
                /* 1 2 3 4 5 6, if 1 2 3 is 1 count, then 2 3 4 has the same count, plus 1 2 3 4 addition count */
                current++;
                sum += current;
            }else {
                current = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] A = new int[]{7,7,7,7};
        System.out.println(new Arithmetic_Slices().numberOfArithmeticSlices(A));
    }
}
