/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

 You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 Example 1:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 Output:
 [[1,2,3,4]]
 Explanation:
 The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 Example 2:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 2, c = 4
 Output:
 [[1,2],
 [3,4]]
 Explanation:
 There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 Note:
 The height and width of the given matrix is in range [1, 100].
 The given r and c are all positive.
 */
public class Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        /* prepare data */
        int volumn = r*c;
        int old_coloumn = nums[0].length;
        /* validate the original matrix, return it if not valid */
        if(nums.length==0 || old_coloumn==0 || nums.length*nums[0].length != volumn)
            return nums;
        int[][] new_matrix = new int[r][c];
        /* linear scanning, use divide and remainders to locate indexes */
        for(int i=0; i<volumn; i++){
            new_matrix[i/c][i%c] = nums[i/old_coloumn][i%old_coloumn];
        }
        return new_matrix;
    }
    public static void main(String[] args){
        int[][] test = {{1,2},{3,4}};
        System.out.print(new Reshape_the_Matrix().matrixReshape(test, 1,4));
    }
}
