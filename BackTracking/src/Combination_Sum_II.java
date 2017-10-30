import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]*/
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int pos, int[] candidates, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
        }
        while(pos < candidates.length){
            if(target - candidates[pos] >= 0){
                list.add(candidates[pos]);
                helper(res, list, pos + 1, candidates, target - candidates[pos]);
                list.remove(list.size() - 1);
                while(pos < candidates.length - 1 && candidates[pos] == candidates[pos + 1]) pos++;
                pos++;
            }else {
                return;
            }

        }
    }
    public static void main(String[] args){
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1,5};
        List<List<Integer>> lists = new Combination_Sum_II().combinationSum2(candidates, 8);
        for(List<Integer> li : lists){
            System.out.println(li);
        }
    }
}
