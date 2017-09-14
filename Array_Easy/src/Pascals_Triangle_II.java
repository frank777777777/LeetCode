import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        /* Initialize and check for empty */
        List<Integer> row = new ArrayList<>();
        // so the index starts from 0
        rowIndex++;
        if(rowIndex<1)
            return row;
        /* Each row has one more element, and set the value to be the sum of the value at the exact position and position after */
        for(int i=1;i<=rowIndex;i++){
            row.add(0,1);
            for(int j=1;j<i-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
        }
        return row;
    }
    public static void main(String[] args){
        List<Integer> list = new Pascals_Triangle_II().getRow(0);
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");

    }
}
