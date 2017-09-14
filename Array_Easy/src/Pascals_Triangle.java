
import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows){
        /* Create new list, and return empty if numRows is zero */
        List<List<Integer>> pascals = new ArrayList<>();
        if(numRows<1)
            return pascals;
        ArrayList<Integer> row = new ArrayList<>();
        /* loop numrows times */
        for(int i=1;i<=numRows;i++){
            row.add(0,1);
            /* My observation is the new value of this position, is the value it is now plus the one at next position */
            for(int j=1;j<i-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
            pascals.add((List)new ArrayList<>(row));
        }
        return pascals;
    }


    public static void main(String[] args){
        int num = 5;
        List<List<Integer>> result = new Pascals_Triangle().generate(num);
    }


//    public List<List<Integer>> generate(int numRows)
//    {
//        List<List<Integer>> pascals = new ArrayList<>();
//        /* if numRows is less than 1, just return empty */
//        if(numRows<1)
//            return pascals;
//        /* outer loop going through each row */
//        for(int i=0;i<numRows;i++){
//            /* each row, create a new row */
//            List<Integer> row = new ArrayList<>();
//            /* for each row, add 1 if it is the head or tail */
//            for(int j=0;j<=i;j++){
//                if(j==0 || j==i)
//                    row.add(1);
//                else
//                    row.add(j,pascals.get(i-1).get(j-1)+pascals.get(i-1).get(j));
//            }
//            pascals.add(i,row);
//        }
//        return pascals;
//
//    }
}
