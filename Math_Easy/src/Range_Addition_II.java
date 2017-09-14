/**
 * Given an m * n matrix M initialized with all 0's and several update operations.

 Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

 You need to count and return the number of maximum integers in the matrix after performing all the operations.

 Example 1:
 Input:
 m = 3, n = 3
 operations = [[2,2],[3,3]]
 Output: 4
 Explanation:
 Initially, M =
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

 After performing [2,2], M =
 [[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

 After performing [3,3], M =
 [[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

 So the maximum integer in M is 2, and there are four of it in M. So return 4.
 Note:
 The range of m and n is [1,40000].
 The range of a is [1,m], and the range of b is [1,n].
 The range of operations size won't exceed 10,000.*/
public class Range_Addition_II {
    /* we do not actually compute the matrix, instead, we only care about how many
    * elements will be added 1, which will be the cross product of the minimum area*/
    public int maxCount(int m, int n, int[][] ops) {
        /* if there is no operation, then just return the size of the whole matrix */
        if(ops.length == 0)
            return m * n;
        int min_n = Integer.MAX_VALUE, min_m = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++){
            /* looking for the minimum m and n, which are getting added the most of time,
            * therefore will be the largest number in the result matrix */
            min_n = min_n < ops[i][0] ? min_n : ops[i][0];
            min_m = min_m < ops[i][1] ? min_m : ops[i][1];
        }
        return min_m * min_n;
    }
}
