/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:

 */
public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        /* Iterate all element. when we find a 1, we check for its perimeter, and add to the sum */
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    perimeter += perimeter_count(grid,i,j);
                }
            }
        }
        return perimeter;
    }
    public int perimeter_count(int[][] grid, int i, int j){
        int count=0;
        /* If it is at the boundary, or it is adjacent to 0, then add 1 perimeter */
        if(i==0 || grid[i-1][j]==0){
            count++;
        }
        if(i==grid.length-1 || grid[i+1][j]==0){
            count++;
        }
        if(j==0 || grid[i][j-1]==0){
            count++;
        }
        if(j==grid[0].length-1 || grid[i][j+1]==0){
            count++;
        }
        return count;
    }
    public static void main(String[] args){
//        int[][] grid = {{0,1,0,0},
//                        {1,1,1,0},
//                        {0,1,0,0},
//                        {1,1,0,0}};
        int[][] grid = {{1},{0}};
        System.out.print(new Island_Perimeter().islandPerimeter(grid));
    }
}
