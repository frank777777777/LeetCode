import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if(k > n) return null;
        List<List<Integer>> res = new ArrayList<>();
        combineHelper(k, 1, n, res, new ArrayList<>());
        return res;
    }
    private void combineHelper(int k, int pos, int n, List<List<Integer>> res, List<Integer> preList){
        if(k == 0){
            res.add(new ArrayList<>(preList));
            return;
        }
        while(pos <= n){
            preList.add(pos);
            combineHelper(k - 1, pos + 1, n, res, preList);
            preList.remove(preList.size() - 1);
            pos++;
        }
    }

    public static void main(String[] args){
        List<List<Integer>> list = new Combinations().combine(1, 0);
        for(List<Integer> li : list){
            System.out.println(li);
        }
    }
}
