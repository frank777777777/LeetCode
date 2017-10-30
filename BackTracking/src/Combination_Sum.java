import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]*/
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /* to avoid pick same elements in different order */
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    public void combinationSumHelper(int[] candidates, int target, int pos, List<Integer> list, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            if(target - candidates[i] >= 0){
                list.add(candidates[i]);
                /* next recursion can start from i, but not before i, avoid same elements different order */
                combinationSumHelper(candidates, target - candidates[i], i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args){
        int[] candidates = new int[]{1,3,5,7,9,11};
        int target = 15;
        List<List<Integer>> list = new Combination_Sum().combinationSum(candidates, target);
        for(List<Integer> li : list){
            System.out.println(li);
        }
    }

}
