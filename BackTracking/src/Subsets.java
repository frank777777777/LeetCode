import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]*/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> numsList = new ArrayList<>();
        res.add(new LinkedList<>());
        subsetsHelper(res, numsList, nums, 0);

        return res;
    }

    private void subsetsHelper(List<List<Integer>> res, List<Integer> numList, int[] nums, int pos){
//        if(pos == nums.length){
//            return;
//        }

        for(int i = pos; i < nums.length; i++){
            numList.add(nums[i]);
            res.add(new LinkedList<>(numList));
            subsetsHelper(res, numList, nums, i + 1);
            numList.remove(numList.size()-1);
        }
    }
    public static void main(String[] args){
        Subsets ss = new Subsets();
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> res = ss.subsets(nums);
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }
    }
}
