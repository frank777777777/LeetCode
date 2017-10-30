import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]*/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        permutationHelper(nums, 0, res);
        return res;
    }

    private void permutationHelper(int[] nums, int pos, List<List<Integer>> res){
        if(pos == nums.length - 1){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer i : nums){
                temp.add(i);
            }
            res.add(temp);
        }

        /* swap position i, with every value after it */
        for(int i = pos; i <= nums.length - 1; i++){
            swap(nums, pos, i); /* swap it and swap it back at the same level */
            permutationHelper(nums, pos + 1, res);
            swap(nums, pos, i);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        Permutations pm = new Permutations();
        List<List<Integer>> list = pm.permute(nums);
        for(List<Integer> l : list){
            System.out.println(l.toString());
        }
    }
}
