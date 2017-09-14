import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Example:
 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        /* map stores distance and its number of appearance */
        HashMap<Double,Integer> map = new HashMap<>();
        int count=0;
        double distance_square;
        /* loop through all points, for each point i, check the distance of every other points to it */
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j)    /* skip itself */
                    continue;
                distance_square=distance_square(points[i],points[j]);
                /* count the distance appearance */
                map.put(distance_square,map.getOrDefault(distance_square,0)+1);
            }
            /* the permutation. value is how many time this distance appeared with the same pivot point.
            * value!/(value-2)! = value*(value-1) */
            for(int value:map.values()){
                count+=value*(value-1);
            }
            map.clear();    /* clear the map so we can reuse it. Avoid the map building overhead */
        }
        return count;
    }
    public double distance_square(int[] a, int[] b){
        return Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2);
    }
    public static void main(String[] args){
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.print(new Number_of_Boomerangs().numberOfBoomerangs(points));
    }

}
