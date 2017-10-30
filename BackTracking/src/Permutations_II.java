import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]*/
public class Permutations_II {

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        permuteUniqueHelper(res,0, nums);
//        return res;
//
//    }
//    private void permuteUniqueHelper(List<List<Integer>> res, int pos, int[] nums){
//        if(pos == nums.length){
//            LinkedList<Integer> listTemp = new LinkedList<>();
//            for(Integer i : nums){
//                listTemp.add(i);
//            }
//            res.add(listTemp);
//            return;
//        }
//        int i = pos;
//        while (i < nums.length) {
//            swap(nums, pos, i);
//            permuteUniqueHelper(res, pos + 1, nums);
//            swap(nums, pos, i);
//            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
//            i++;
//        }
//    }
//    public void swap(int[] nums, int i, int j){
//        int temp;
//        temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if(nums==null || nums.length==0) return res;
    boolean[] used = new boolean[nums.length];
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums);
    dfs(nums, used, list, res);
    return res;
}

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue; /* only add this value if it is not used */
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue; /* if previous value is not used, then don't use this value either. If the value is skipped,
                                                                    list.size()==nums.length wont be satistifed, therefore this duplicate will be eliminated */
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{0, 0,0, 1};
        List<List<Integer>> lists = new Permutations_II().permuteUnique(nums);
        for(List<Integer> li : lists){
            System.out.println(li);
        }
    }
}
