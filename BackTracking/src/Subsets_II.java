import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]*/
/* import part from Subset I, is we sort the int[] nums, and loop through duplicate number to avoid duplicates */
public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        help(res, new ArrayList<>(), 0, nums);
        return res;

    }
    private void help(List<List<Integer>> res, List<Integer> list, int pos, int[] nums){

        while(pos < nums.length){
            list.add(nums[pos]);
            res.add(new ArrayList<>(list));
            help(res, list, pos + 1, nums);
            list.remove(list.size() - 1);
            /* move to the next, until the next value will be different, thus removing duplicates */
            while(pos < nums.length - 1 && nums[pos] == nums[pos + 1]) pos++;
            pos++;
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> list = new Subsets_II().subsetsWithDup(nums);
        for(List<Integer> li : list){
            System.out.println(li);
        }
    }
}
